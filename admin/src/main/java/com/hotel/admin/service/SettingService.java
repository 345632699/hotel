package com.hotel.admin.service;

import com.hotel.model.RoomSetting;

import java.util.List;

public interface SettingService {
    RoomSetting create(RoomSetting roomSetting);
    void update(RoomSetting roomSetting);
    void delete(Integer id);
    List<RoomSetting> allList();
}
