package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @ClassName
 * @Description 用户mapper
 * @Author wanghuanle
 * @Date
 **/
public interface UserMapper {

    /**
     * 根据手机号查找用户
     *
     * @param phone
     * @return User
     * @throws SQLException
     * @author wanghuanle
     * @date 2021.04.24
     */
    @Select("SELECT * FROM sys_user WHERE phone = #{phone}")
    SysUser findUserByMobile(@Param("phone") String phone) throws SQLException;


    /**
     * 新增用户，并返回自增主键
     *
     * @param sysUser
     * @throws SQLException
     */
    @Insert("INSERT INTO sys_user(user_name,phone,avatar) VALUES (#{userName},#{phone},#{avatar}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(SysUser sysUser) throws SQLException;
}
