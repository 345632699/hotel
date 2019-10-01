package com.hotel.minapp.service;

import com.hotel.common.PageModel;
import com.hotel.minapp.dto.ReserveList;
import com.hotel.minapp.dto.RoomDto;
import com.hotel.minapp.query.CheckInQuery;
import com.hotel.minapp.query.CheckOutQuery;
import com.hotel.minapp.query.RoomQuery;

public interface RoomService {
    PageModel<RoomDto> getRoomList(RoomQuery roomQuery);
    RoomDto roomInfo(Integer id);
    ReserveList canNotReserveList(CheckInQuery checkInQuery, Integer month);
}
