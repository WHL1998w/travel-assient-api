package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.domain.dto.AdminDto;
import com.soft1841.travel.api.domain.dto.LoginDto;
import com.soft1841.travel.api.domain.entity.RoleMenu;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.soft1841.travel.api.service.SysAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@RequestMapping(value = "/sysAdmin")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "用户管理接口", value = "用户相关的Rest API")
public class SysAdminController {

    @Resource
    private SysAdminService sysAdminService;

    /**
     * 管理员登录
     * @param loginDto
     * @return String
     */
    @PostMapping("/login")
    @ApiOperation(value = "账号密码验证码登录", notes = "账号密码验证码登录")
    public Map login(@RequestBody @Valid LoginDto loginDto) {
        log.info(loginDto.toString());
        return sysAdminService.login(loginDto);
    }

    /**
     * 根据id查询管理员信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据管理员id查询信息", notes = "根据管理员id查询信息")
    public SysAdmin getSysAdmin(@PathVariable String id) {
        log.info(sysAdminService.getSysAdminById(id).toString());
        return sysAdminService.getSysAdminById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改管理员信息", notes = "修改管理员信息")
    SysAdmin updateSysAdmin(@RequestBody SysAdmin sysAdmin){
        return sysAdminService.updateSysAdmin(sysAdmin);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增管理员", notes = "新增管理员")
    public AdminDto insertAdmin(@RequestBody AdminDto adminDto){
        log.info((adminDto.toString()));
        return this.sysAdminService.insertAdmin(adminDto);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除管理员", notes = "删除管理员")
    public AdminDto deleteAdmin(@RequestBody AdminDto AdminDto){
        log.info((AdminDto.toString()));
        return this.sysAdminService.deleteAdmin(AdminDto);
    }
}
