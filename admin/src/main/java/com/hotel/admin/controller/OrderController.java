package com.hotel.admin.controller;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.hotel.admin.query.CheckOutOrCancelQuery;
import com.hotel.admin.query.OrderQuery;
import com.hotel.admin.service.OrderService;
import com.hotel.common.ApiResponse;
import com.hotel.common.PageModel;
import com.hotel.model.RoomOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

  @Autowired
  OrderService orderService;

  @PostMapping(value = "list")
  public ApiResponse orderList(@RequestBody OrderQuery orderQuery){
    PageModel<RoomOrder> orderListByPage = orderService.getOrderListByPage(orderQuery);
    return ApiResponse.ofSuccess(orderListByPage);
  }

  @PostMapping(value = "checkout")
  public ApiResponse checkoutRoom(@RequestBody CheckOutOrCancelQuery checkOutOrCancelQuery) throws WxPayException {
    checkOutOrCancelQuery.setType(1);
    orderService.checkout(checkOutOrCancelQuery);
    return ApiResponse.ofSuccess();
  }

  @PostMapping(value = "cancelOrder")
  public ApiResponse cancel(@RequestBody CheckOutOrCancelQuery cancelQuery) throws WxPayException {
    cancelQuery.setType(2);
    orderService.cancel(cancelQuery);
    return ApiResponse.ofSuccess();
  }

}
