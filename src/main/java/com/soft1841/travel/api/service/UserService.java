package com.soft1841.travel.api.service;

import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.UserDto;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
public interface UserService {
    /**
     * 获取短信验证
     * @param phone
     * @return
     */

    Result sendSms(String phone);

    /**
     * 验证短信是否正确（signDto中有手机号和验证码两部分内容）
     * @param userDto
     * @return Result
     */
    Result checkSms(UserDto userDto);

    /**
     * 用户登录功能
     *
     * @param userDto
     * @return Result
     */
    Result login(UserDto userDto);


    /***
     * 根据手机号查询用户的全部信息
     * @param phone
     * @return
     */
    Result getUserByMobile(String phone);


}
