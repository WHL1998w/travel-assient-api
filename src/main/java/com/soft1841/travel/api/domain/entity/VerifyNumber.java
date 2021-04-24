package com.soft1841.travel.api.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName
 * @Description 手机号验证码时间
 * @Author wanghuanle
 * @Date
 **/
@Data
public class VerifyNumber implements Serializable {
    private String code;
    private Date time;
    private String mobile;

    public VerifyNumber(String mobile, String verifyCode, Date date) {
        this.code = verifyCode;
        this.time = date;
        this.mobile = mobile;
    }
}
