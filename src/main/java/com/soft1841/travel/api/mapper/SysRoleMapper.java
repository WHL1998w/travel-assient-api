package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据id查询角色，包含其所有菜单
     * @param roleId
     * @return
     */
    SysRole selectRoleById(int roleId);

}
