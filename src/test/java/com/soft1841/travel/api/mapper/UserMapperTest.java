package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.entity.SysUser;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void insert() {
        SysUser sysUser=new SysUser();
        sysUser.setUserName("用户：18851853957");
        sysUser.setPhone("18851853957");
        sysUser.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/default.png");
        try {
            userMapper.insertUser(sysUser);
        } catch (SQLException e) {
            System.out.println("新增用户信息"+sysUser);
        }
    }
}