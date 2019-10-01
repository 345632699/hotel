package com.hotel.minapp.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginQuery {

    @NotBlank(message = "appid不能为空")
    String appid;
    @NotBlank(message = "signature不能为空")
    String signature;
    @NotBlank(message = "rawData不能为空")
    String rawData;
    @NotBlank(message = "encryptedData不能为空")
    String encryptedData;
    @NotBlank(message = "iv不能为空")
    String iv;
    @NotBlank(message = "code不能为空")
    String code;
}
