package com.hotel.admin.service.impl;

import com.hotel.admin.exception.CustomException;
import com.hotel.admin.service.BaseService;
import com.hotel.admin.service.SettingService;
import com.hotel.common.Status;
import com.hotel.model.RoomSetting;
import com.hotel.model.RoomSettingExample;
import com.hotel.model.RoomSettingMapping;
import com.hotel.model.RoomSettingMappingExample;
import com.hotel.model.mapper.RoomSettingMapper;
import com.hotel.model.mapper.RoomSettingMappingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {

  @Autowired
  private RoomSettingMapper roomSettingMapper;

  @Autowired
  private RoomSettingMappingMapper settingMappingMapper;

  @Override
  public RoomSetting create(RoomSetting roomSetting) {
    roomSetting.setCreatedAt(new Date());
    roomSetting.setUpdatedAt(new Date());
    roomSettingMapper.insertSelective(roomSetting);
    return roomSetting;
  }

  @Override
  public void update(RoomSetting roomSetting) {
    roomSettingMapper.updateByPrimaryKey(roomSetting);
  }

  @Override
  public void delete(Integer id) {
    RoomSettingMappingExample roomSettingMappingExample = new RoomSettingMappingExample();
    RoomSettingMappingExample.Criteria criteria = roomSettingMappingExample.createCriteria();
    criteria.andRoomSettingIdEqualTo(id);
    List<RoomSettingMapping> roomSettingMappings = settingMappingMapper.selectByExample(roomSettingMappingExample);
    if (roomSettingMappings.size() > 0) {
      throw new CustomException(Status.SETTING_EXIST_RECOMMEND);
    }
    roomSettingMapper.deleteByPrimaryKey(id);
  }

  @Override
  public List<RoomSetting> allList() {
    return roomSettingMapper.selectByExample(new RoomSettingExample());
  }
}
