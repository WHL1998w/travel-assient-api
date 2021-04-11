package com.soft1841.travel.api.service.impl;

import com.soft1841.travel.api.domain.entity.RoleMenu;
import com.soft1841.travel.api.mapper.RoleMenuMapper;
import com.soft1841.travel.api.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    private final RoleMenuMapper roleMenuMapper;

    /**
     * 新增角色菜单（权限）
     * @param roleMenu
     * @return
     */
    @Override
    public RoleMenu insertRoleMenu(RoleMenu roleMenu) {
        roleMenuMapper.insertRoleMenu(roleMenu.getRoleId(),roleMenu.getMenuId());
        return roleMenu;
    }

    /**
     * 根据id取消、删除角色对应的菜单
     * @param roleMenu
     * @return
     */
    @Override
    public RoleMenu deleteRoleMenu(RoleMenu roleMenu) {
        roleMenuMapper.deleteRoleMenu(roleMenu.getId());
        return roleMenu;
    }
}
