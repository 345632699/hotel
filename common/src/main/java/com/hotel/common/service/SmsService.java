package com.hotel.common.service;

import com.hotel.model.SmsCode;
import com.hotel.model.SmsCodeExample;
import com.hotel.model.mapper.SmsCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsService {
    @Autowired
    SmsCodeMapper smsCodeMapper;

    public Integer insertRecord(SmsCode sms) {
        return smsCodeMapper.insertSelective(sms);
    }

    public Integer update(SmsCode sms) {
        return smsCodeMapper.updateByPrimaryKeySelective(sms);
    }

    public SmsCode findByPhone(String mobile) {
        SmsCodeExample smsCodeExample = new SmsCodeExample();
        smsCodeExample.setOrderByClause("id DESC");
        SmsCodeExample.Criteria criteria = smsCodeExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<SmsCode> smsCodes = smsCodeMapper.selectByExample(smsCodeExample);
        if (smsCodes.size() > 0) {
            return smsCodes.get(0);
        } else {
            return null;
        }
    }
}
