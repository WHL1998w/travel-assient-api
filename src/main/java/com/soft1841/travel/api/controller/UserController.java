package com.soft1841.travel.api.controller;

import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.UserDto;
import com.soft1841.travel.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "用户接口", value = "用户相关的Rest API")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据手机号查询用户的所有信息
     * @param phone(成功)
     * @return
     */
    @GetMapping(value = "/findUserByMobile/{phone}")
    @ApiOperation(value = "根据手机号查询用户的所有信息", notes = "根据手机号查询用户的所有信息")
    Result findUserByMobile(@PathVariable("phone") @Valid String phone){
        return  userService.getUserByMobile(phone);
    }

    /**
     * 获取手机验证码
     */
    @PostMapping(value = "/sms/{phone}")
    @ApiOperation(value = "获取手机验证码", notes = "获取手机验证码")
    Result getSms(@PathVariable("phone") @Valid String phone) {
        return userService.sendSms(phone);
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "根据短信验证登录", notes = "根据短信验证登录")
    public Result signIn(@RequestBody UserDto userDto) throws IOException {
        return  userService.login(userDto);
    }
}
