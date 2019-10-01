package com.hotel.admin.service;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.hotel.admin.query.CheckOutOrCancelQuery;
import com.hotel.admin.query.OrderQuery;
import com.hotel.common.PageModel;
import com.hotel.model.RoomOrder;

public interface OrderService {
    String index();
    PageModel<RoomOrder> getOrderListByPage(OrderQuery orderQuery);
    void checkout(CheckOutOrCancelQuery checkOutOrCancelQuery) throws WxPayException;
    void cancel(CheckOutOrCancelQuery cancelQuery) throws WxPayException;
}
