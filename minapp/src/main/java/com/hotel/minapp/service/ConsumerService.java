package com.hotel.minapp.service;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.hotel.minapp.query.ConsumerQuery;
import com.hotel.minapp.vo.ConsumerVo;
import com.hotel.model.WxConsumer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ConsumerService {
    String index();
    List<WxConsumer> getConsumerByOpenId(String openId);
    void createConsumer(WxMaUserInfo userInfo);
    void bindPhone(ConsumerQuery consumerQuery, HttpServletRequest request);
    ConsumerVo userInfoByOpenIdOrUnionId(String openIdOrUnionId);
}
