package com.hotel.minapp.service;

import com.hotel.minapp.dto.RoomOrderDto;
import com.hotel.minapp.query.RoomOrderQuery;

public interface OrderService {
    Integer createOrder(RoomOrderQuery roomOrderQuery, String openId);
    RoomOrderDto getInfoById(int id);
}
