package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
     * 新增管理员admin
     * @param account
     * @param password
     * @param salt
     */
    @Insert("INSERT INTO sys_admin(id,account,password,avatar,salt) values (#{id},#{account},#{password},#{avatar},#{salt})")
    void insertAdmin(@Param("id") String id, @Param("account") String account,
                     @Param("password") String password,@Param("avatar")String avatar,
                     @Param("salt") String salt);

    /**
     * 删除管理员
     * @param id
     */
    @Delete("DELETE FROM sys_admin WHERE id = #{id}")
    void deleteAdmin(@Param("id") String id);
}
