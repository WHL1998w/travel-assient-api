package com.soft1841.travel.api.service;

import com.soft1841.travel.api.domain.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface RoleMenuService extends IService<RoleMenu> {


    /**
     * 新增角色拥有的菜单
     * @param roleMenu
     * @return
     */
    RoleMenu insertRoleMenu(RoleMenu roleMenu);

    /**
     * 根据id删除角色菜单
     * @param roleMenu
     * @return
     */
    RoleMenu deleteRoleMenu(RoleMenu roleMenu);
}
