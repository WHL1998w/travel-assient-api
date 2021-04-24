package com.soft1841.travel.api.domain.dto;

import lombok.Data;

/**
 * @ClassName
 * @Description 用来实现用户手机短信验证登录功能
 * @Author wanghuanle
 * @Date
 **/
@Data
public class UserDto {
    private String phone;
    private String code;
}
