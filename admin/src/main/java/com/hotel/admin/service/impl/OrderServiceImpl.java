package com.hotel.admin.service.impl;

import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.hotel.admin.query.CheckOutOrCancelQuery;
import com.hotel.admin.query.OrderQuery;
import com.hotel.admin.service.OrderService;
import com.hotel.common.PageModel;
import com.hotel.model.*;
import com.hotel.model.mapper.PayOrderMapper;
import com.hotel.model.mapper.PayReturnOrderMapper;
import com.hotel.model.mapper.RoomMapper;
import com.hotel.model.mapper.RoomOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private RoomOrderMapper roomOrderMapper;
    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PayReturnOrderMapper payReturnOrderMapper;

    @Autowired
    WxPayService wxPayService;

    @Value("${wx.pay.appId}")
    private String appId;

    @Value("${wx.pay.refundUrl}")
    private String refundUrl;

    @Value("${wx.pay.mchId}")
    private String mchId;

    @Override
    public String index() {
        return null;
    }


    @Override
    public PageModel<RoomOrder> getOrderListByPage(OrderQuery orderQuery) {

        List<Integer> roomIds = Collections.EMPTY_LIST;
        PageModel<RoomOrder> orders = new PageModel<>();
        RoomOrderExample roomOrderExample = new RoomOrderExample();
        RoomOrderExample.Criteria criteria = roomOrderExample.createCriteria();

        if (orderQuery.getApartmentId() >= 0) {
            Integer apartmentId = orderQuery.getApartmentId();
            RoomExample roomExample = new RoomExample();
            RoomExample.Criteria roomExampleCriteria = roomExample.createCriteria();
            roomExampleCriteria.andApartmentIdEqualTo(apartmentId);
            List<Room> rooms = roomMapper.selectByExample(roomExample);
            if (rooms.size() > 0) {
               roomIds = rooms.stream().map(Room::getId).collect(Collectors.toList());
            }

            if (roomIds.size() > 0) {
                criteria.andRoomIdIn(roomIds);
            } else {
                criteria.andRoomIdEqualTo(-1);
            }
        }



        // 排序
        /**
         * 0 退房时间由就到新
         * 1 入住时间由旧到新
         * 2 退房时间由新到旧
         * 3 入住时间由新到旧
         */
        if (orderQuery.getSort() != null) {
            switch (orderQuery.getSort()){
                case 0:
                    roomOrderExample.setOrderByClause("check_out_time asc");
                    break;
                case 1:
                    roomOrderExample.setOrderByClause("check_in_time asc");
                    break;
                case 2:
                    roomOrderExample.setOrderByClause("check_out_time desc");
                    break;
                case 3:
                    roomOrderExample.setOrderByClause("check_in_time desc");
                    break;
            }
        }

        if (orderQuery.getPayStatus() >= 0) {
            criteria.andPayStatusEqualTo(orderQuery.getPayStatus());
        }

        if (orderQuery.getOrderStatus() >= 0) {
            criteria.andStatusEqualTo(orderQuery.getOrderStatus());
        }

        int totalCount = roomOrderMapper.countByExample(roomOrderExample);

        roomOrderExample.setLimit(orderQuery.getLimit());
        roomOrderExample.setOffset((orderQuery.getPage() - 1) * orderQuery.getLimit());

        List<RoomOrder> roomOrders = roomOrderMapper.selectByExample(roomOrderExample);

        orders.setData(roomOrders);
        orders.setTotalCount(totalCount);
        orders.setCurrentPage(orderQuery.getPage());
        orders.setLimit(orderQuery.getLimit());
        return orders;
    }

    @Override
    public void checkout(CheckOutOrCancelQuery checkOutOrCancelQuery) throws WxPayException {
        Integer roomOrderId = checkOutOrCancelQuery.getRoomOrderId();
        RoomOrder roomOrder = roomOrderMapper.selectByPrimaryKey(roomOrderId);
        // 更改订单状态
        roomOrder.setStatus(3);
        roomOrderMapper.updateByPrimaryKey(roomOrder);

        // 更新密码
        Room room = roomMapper.selectByPrimaryKey(roomOrder.getRoomId());
        room.setRoomPassword(checkOutOrCancelQuery.getPassword());
        roomMapper.updateByPrimaryKey(room);

        // 退押金
        wxReFund(roomOrder, checkOutOrCancelQuery.getReturnPrice(), checkOutOrCancelQuery);

    }

    @Override
    public void cancel(CheckOutOrCancelQuery cancelQuery) throws WxPayException {
        RoomOrder roomOrder = roomOrderMapper.selectByPrimaryKey(cancelQuery.getRoomOrderId());
        roomOrder.setStatus(4);
        roomOrderMapper.updateByPrimaryKey(roomOrder);

        Room room = roomMapper.selectByPrimaryKey(roomOrder.getRoomId());
        room.setRoomPassword(cancelQuery.getPassword());
        roomMapper.updateByPrimaryKey(room);

        if (cancelQuery.getReturnPrice().compareTo(BigDecimal.ZERO) > 0) {
            // 退押金
            wxReFund(roomOrder, cancelQuery.getReturnPrice(), cancelQuery);
        }
    }

    private void wxReFund(RoomOrder roomOrder, BigDecimal returnPrice, CheckOutOrCancelQuery checkOutOrCancelQuery) throws WxPayException {
        PayReturnOrder payReturnOrder = new PayReturnOrder();
        payReturnOrder.setPrice(returnPrice.multiply(BigDecimal.valueOf(100)).intValue());
        payReturnOrder.setOpenId(roomOrder.getOpenId());
        payReturnOrder.setOrderSn(roomOrder.getOrderSn());

        if (checkOutOrCancelQuery.getType().equals(1)) {
            payReturnOrder.setMemo("押金退款");
        }

        if (checkOutOrCancelQuery.getType().equals(2)) {
            payReturnOrder.setMemo("取消订单退款");
        }

        PayOrderExample payOrderExample = new PayOrderExample();
        PayOrderExample.Criteria criteria = payOrderExample.createCriteria();
        criteria.andOrderSnEqualTo(roomOrder.getOrderSn());
        criteria.andPayStatusEqualTo((byte) 1);
        List<PayOrder> payOrders = payOrderMapper.selectByExample(payOrderExample);
        PayOrder payOrder = payOrders.get(0);
        payReturnOrder.setPayId(payOrder.getPayId());
        payReturnOrder.setPayName(payOrder.getPayName());
        String returnNo = "D_" + System.currentTimeMillis();
        payReturnOrder.setReturnNo(returnNo);
        payReturnOrder.setCreatedAt(new Date());
        payReturnOrder.setUpdatedAt(new Date());

        payReturnOrderMapper.insertSelective(payReturnOrder);

        WxPayRefundRequest wxPayRefundRequest = new WxPayRefundRequest();
        wxPayRefundRequest.setNotifyUrl(refundUrl);
        wxPayRefundRequest.setOutTradeNo(payReturnOrder.getOrderSn());
        wxPayRefundRequest.setTransactionId(payOrder.getWxOrderSn());
        wxPayRefundRequest.setTotalFee(payReturnOrder.getPrice());
        wxPayRefundRequest.setRefundFee(payReturnOrder.getPrice());
        wxPayRefundRequest.setAppid(appId);
        wxPayRefundRequest.setMchId(mchId);
        wxPayRefundRequest.setOutRefundNo(payReturnOrder.getReturnNo());

        WxPayRefundResult refund = wxPayService.refund(wxPayRefundRequest);
        if (refund.getReturnCode().equals("SUCCESS")) {

        } else {
            throw new WxPayException("退款失败");
        }
    }
}
