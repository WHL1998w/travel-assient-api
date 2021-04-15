package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 新增角色拥有的菜单
     * @param roleId
     * @param menuId
     */
    @Insert("INSERT INTO role_menu(role_id,menu_id) values (#{roleId},#{menuId})")
    void insertRoleMenu(@Param("roleId")Integer roleId,@Param("menuId") Integer menuId);

    /**
     * 删除角色拥有的菜单
     * @param id
     */
    @Delete("DELETE FROM role_menu WHERE id = #{id}")
    void deleteRoleMenu(@Param("id")Integer id);
}
