package com.soft1841.travel.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ClientException;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.UserDto;
import com.soft1841.travel.api.domain.entity.SysUser;
import com.soft1841.travel.api.mapper.UserMapper;
import com.soft1841.travel.api.service.RedisService;
import com.soft1841.travel.api.service.UserService;
import com.soft1841.travel.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @Override
    public Result sendSms(String phone) {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAIIm8fabNgBfYz",
                "kWn7Vr6hH4HEODQ5cOsPYjP6kEr5lo");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "大二实训项目");
        request.putQueryParameter("TemplateCode", "SMS_205462480");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            log.error("短信发送异常");
            return Result.failure(ResultCode.SMS_ERROR);
        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
        }
        //resData样例：{"Message":"OK","RequestId":"0F3A84A6-55CA-4984-962D-F6F54281303E","BizId":"300504175696737408^0","Code":"OK"}
        String resData = response.getData();
        //将返回的JSON字符串转成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(resData);
        if ("OK".equals(jsonObject.get("Code"))) {
            System.out.println(verifyCode);
            //存入redis，3分钟有效
            redisService.set(phone, verifyCode, 3L);
            return Result.success(verifyCode);
        } else {
            return Result.failure(ResultCode.SMS_ERROR);
        }
    }

    /**
     * 检查验证码是否正确
     * @param userDto
     * @return
     */
    @Override
    public Result checkSms(UserDto userDto) {
        String phone = userDto.getPhone();
        String sms = userDto.getCode();
        System.out.println(sms);
        String correctSms = redisService.getValue(phone, String.class);
        if (correctSms != null) {
            //将客户端传来的短信验证码和redis取出的短信验证码比对
            if (correctSms.equals(sms)) {
                return Result.success();
            } else {
                //验证码错误
                Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
            }
        }
        //验证码失效
        return Result.failure(ResultCode.USER_CODE_TIMEOUT);
    }

    /**
     * 登录功能：如果手机号存在登录成功，如果手机号不存在新增，带入默认的用户名，头像等信息，并直接登录成功
     * @param userDto
     * @return
     */
    @Override
    public Result login(UserDto userDto) {
        //调用验证功能
        Result result = userService.checkSms(userDto);
        //验证通过
        if (result.getCode() == 1) {
            String mobile = userDto.getPhone();
            SysUser user;
            try {
                //根据手机号查询用户信息
                user = userMapper.findUserByMobile(mobile);
            } catch (SQLException e) {
                logger.error("根据手机号查询用户出现异常");
                return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
            }
            //用户信息若为空，新增用户
            if (user == null) {
                SysUser sysUser=new SysUser();
                sysUser.setUserName("用户"+mobile);
                sysUser.setPhone(mobile);
                sysUser.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/default.png");
                try {
                    userMapper.insertUser(sysUser);
                } catch (SQLException e) {
                    logger.error("新增用户出现异常");
                    return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
                }
                return  Result.success("登录成功"+sysUser);
            } else {
                return Result.success("登录成功"+ user);
            }
        }else {
            return  Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
        }
    }

    @Override
    public Result getUserByMobile(String phone) {
        SysUser user=null;
        try{
            user=userMapper.findUserByMobile(phone);
        } catch (SQLException e) {
            logger.error("根据手机号查询用户的所有信息出现异常");
        }      if (user != null) {
            return Result.success(user);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

}
