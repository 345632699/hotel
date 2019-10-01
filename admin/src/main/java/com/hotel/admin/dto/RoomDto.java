package com.hotel.admin.dto;

import com.hotel.model.Room;
import com.hotel.model.RoomImages;
import com.hotel.model.RoomSetting;
import com.hotel.model.RoomSpecsItem;
import lombok.Data;

import java.util.List;

@Data
public class RoomDto extends Room {
    List<RoomImages> roomImages;
    List<RoomSetting> roomSettings;
    List<RoomSpecsItem> specsItemList;
}
