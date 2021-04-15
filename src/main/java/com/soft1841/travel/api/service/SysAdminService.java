package com.soft1841.travel.api.service;

import com.soft1841.travel.api.domain.dto.AdminDto;
import com.soft1841.travel.api.domain.dto.LoginDto;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface SysAdminService extends IService<SysAdmin> {
    /**
     * 登录
     *
     * @param loginDto
     * @return boolean
     */
    Map<String,Object> login(LoginDto loginDto);

    /**
     * 根据name查询Admin信息，包含其所有角色
     *
     * @param name
     * @return
     */
    SysAdmin getAdminAndRolesByName(String name);

    /**
     * 为指定的管理员生成token
     * @param adminId
     * @param roles
     * @param secrect
     * @param expiresAt
     * @return String
     */
    String getToken(final String adminId, final String roles, final String secrect, Date expiresAt);

    /**
     * 修改用户信息
     * @param sysAdmin
     * @return
     */
    SysAdmin updateSysAdmin (SysAdmin sysAdmin);

    /**
     * 根据id获取admin
     * @param id
     * @return SysAdminDto
     */
    SysAdmin getSysAdminById(String id);

    /**
     * 新增管理员admin
     * @param adminDto
     * @return
     */
    AdminDto insertAdmin(AdminDto adminDto);

    /**
     * 删除管理员
     * @param adminDto
     * @return
     */
    AdminDto deleteAdmin(AdminDto adminDto);
}
