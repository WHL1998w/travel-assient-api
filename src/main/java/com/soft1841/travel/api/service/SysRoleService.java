package com.soft1841.travel.api.service;

import com.soft1841.travel.api.domain.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据角色id获取角色信息（基础信息和该角色所有菜单）
     * @param roleId
     * @return
     */
    Map<String,Object> selectRoleById(int roleId);

    /**
     * 检查roleId是否在roles中存在
     * @param roles
     * @param roleId
     * @return boolean
     */
    boolean checkRole(List<SysRole> roles, int roleId);

    /**
     * 查询所有角色
     * @return
     */
    List<SysRole> selectAll();
}
