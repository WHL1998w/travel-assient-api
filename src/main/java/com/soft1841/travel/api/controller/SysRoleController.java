package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.domain.entity.SysRole;
import com.soft1841.travel.api.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/sysRole")
@Api(tags = "角色管理接口", value = "用户相关的Rest API")
@Slf4j
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @GetMapping(value = "/{roleId}")
    @ApiOperation(value = "根据角色id查询所有菜单", notes = "根据角色id查询所有菜单")
    public Map getRoleById(@PathVariable Integer roleId) {
        return sysRoleService.selectRoleById(roleId);
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "查询所有角色", notes = "查询所有角色")
    public List<SysRole> getSysRoles() {
        return sysRoleService.selectAll();
    }
}
