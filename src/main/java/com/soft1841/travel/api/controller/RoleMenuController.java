package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.domain.entity.RoleMenu;
import com.soft1841.travel.api.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/roleMenu")
@Api(tags = "用户菜单接口", value = "用户相关的Rest API")
@Slf4j
public class RoleMenuController {
    @Resource
    private RoleMenuService roleMenuService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增用户菜单", notes = "新增用户菜单")
    public RoleMenu insertRoleMenu(@RequestBody RoleMenu roleMenu){
        log.info((roleMenu.toString()));
        return this.roleMenuService.insertRoleMenu(roleMenu);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户菜单", notes = "删除用户菜单")
    public RoleMenu deleteRoleMenu(@RequestBody RoleMenu roleMenu){
        log.info((roleMenu.toString()));
        return this.roleMenuService.deleteRoleMenu(roleMenu);
    }
}
