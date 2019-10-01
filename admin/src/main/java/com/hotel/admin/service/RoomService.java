package com.hotel.admin.service;

import com.hotel.admin.dto.RoomDto;
import com.hotel.admin.query.RoomAddQuery;
import com.hotel.admin.query.RoomQuery;
import com.hotel.common.PageModel;
import com.hotel.model.Room;
import com.hotel.model.RoomSpecsItem;

import java.util.List;

public interface RoomService {
    List<RoomSpecsItem> getRoomSpecs(Integer roomId);
    PageModel<Room> getRoomList(RoomQuery roomQuery);
    RoomDto roomDetail(Integer id);
    void createRoom(RoomAddQuery roomAddQuery);
    void updateRoom(RoomAddQuery roomAddQuery);
    void delete(Integer roomId);

}
