package com.hotel.minapp.controller;

import com.hotel.common.ApiResponse;
import com.hotel.minapp.dto.RoomOrderDto;
import com.hotel.minapp.query.RoomOrderQuery;
import com.hotel.minapp.service.OrderService;
import com.hotel.minapp.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

  @Autowired
  OrderService orderService;

  @PostMapping(value = "create")
  public ApiResponse createOrder(@Valid @RequestBody RoomOrderQuery roomOrderQuery, HttpServletRequest request) {
    String openId = JWTUtil.getOpenId(request);
    Integer orderId = orderService.createOrder(roomOrderQuery, openId);
    Map map = new HashMap();
    map.put("id", orderId);
    return ApiResponse.ofSuccess(map);
  }

  @GetMapping(value = "info")
  public ApiResponse info(@RequestParam Integer id) {
    RoomOrderDto roomOrderDto = orderService.getInfoById(id);
    return ApiResponse.ofSuccess(roomOrderDto);
  }
}
