package com.hotel.minapp.service;

import com.github.binarywang.wxpay.exception.WxPayException;

import javax.servlet.http.HttpServletRequest;

public interface PayService {
  Object getPayConfig(Integer orderId, HttpServletRequest request) throws WxPayException;
  boolean changOrderStatus(String outTradeNo, String transactionId);
}
