package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.dto.AdminDto;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface SysAdminMapper extends BaseMapper<SysAdmin> {
    /**
     * 根据account查询管理员信息，包含其所有角色
     * @param account
     * @return
     */
    SysAdmin selectByName(@Param("account") String account);

    /**
     * 根据account查询admin基础信息，用于个人信息，登录等
     * 避开其中的List<SysRole>属性，因为它没有映射字段
     * @param account
     * @return
     */
    @Select("SELECT * FROM sys_admin WHERE account = #{account}")
    SysAdmin getSysAdminByName(@Param("account") String account);


    /**
     * 根据id查询admin基础信息，用于个人信息，登录等
     * 避开其中的List<SysRole>属性，因为它没有映射字段
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_admin WHERE id = #{id}")
    SysAdmin getSysAdminById(@Param("id") String id);

    /**
     * 新增管理员
     * @param id
     * @param account
     * @param password
     * @param avatar
     * @param salt
     */
    @Insert("INSERT INTO sys_admin(id,account,password,avatar,salt) values (#{id},#{account},#{password},#{avatar},#{salt})")
    void insertAdmin(@Param("id") String id,@Param("account") String account,@Param("password") String password,@Param("avatar") String avatar,@Param("salt") String salt);

    /**
     * 删除管理员
     * @param account
     */
    @Delete("DELETE FROM sys_admin WHERE account = #{account}")
    void deleteAdmin(@Param("account") String account);
}
