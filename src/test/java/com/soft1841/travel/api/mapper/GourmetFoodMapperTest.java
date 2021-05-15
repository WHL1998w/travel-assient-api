package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.*;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GourmetFoodMapperTest {

    @Resource
    private GourmetFoodMapper gourmetFoodMapper;
    private UserMapper userMapper;
    @Test
    void getGourmetFoodById() {
        GourmetFood gourmetFood = gourmetFoodMapper.getGourmetFoodById(1);
        System.out.println(gourmetFood);
//        System.out.println("admin基础信息");
//        System.out.println(gourmetFood.getId());
//        System.out.println(gourmetFood.getRestaurantName());
//        System.out.println(gourmetFood.getPosition());
//        System.out.println("他的所有角色");
//        List<RestComments> restCommentsList = gourmetFood.getRestCommentsList();
//        for (RestComments restComments : restCommentsList) {
//            Integer userId = restComments.getUserId();
//            System.out.println(userId);
//
//            SysUser sysUser = userMapper.selectById(userId);
//            System.out.println(sysUser.getUserName());
//            sysUser.getUserName();
//            sysUser.getAvatar();

//            System.out.println(restComments.getUserId()+restComments.getComments() + ":" + restComments.getCommentsTime());


    }
}