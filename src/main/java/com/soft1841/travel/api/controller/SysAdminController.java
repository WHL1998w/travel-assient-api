package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
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
@Api(tags = "管理员接口", value = "管理员相关的Rest API")
public class SysAdminController {

    @Resource
    private SysAdminService sysAdminService;

    /**
     * 管理员登录
     * @param loginDto
     * @return String
     */
    @PostMapping("/login")
    @ApiOperation(value = "账号密码登录", notes = "账号密码登录")
    public Map login(@RequestBody @Valid LoginDto loginDto) {
        log.info(loginDto.toString());
        return sysAdminService.login(loginDto);
    }


    @PutMapping("/update")
    @ApiOperation(value = "修改管理员信息", notes = "修改管理员信息")
    Result updateSysAdmin(@RequestBody AdminDto sysAdmin){
        return sysAdminService.updateSysAdmin(sysAdmin);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增管理员", notes = "新增管理员")
    public Result insertAdmin(@RequestBody AdminDto adminDto){
        log.info((adminDto.toString()));
        return this.sysAdminService.insertAdmin(adminDto);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除管理员", notes = "删除管理员")
    public Result deleteAdmin(@RequestBody SysAdmin sysAdmin){
        log.info((sysAdmin.toString()));
        return this.sysAdminService.deleteAdmin(sysAdmin);
    }
}
