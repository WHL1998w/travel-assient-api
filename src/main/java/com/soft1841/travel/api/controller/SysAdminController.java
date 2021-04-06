package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.domain.dto.LoginDto;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.soft1841.travel.api.service.SysAdminService;
import lombok.extern.slf4j.Slf4j;
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
public class SysAdminController {

    @Resource
    private SysAdminService sysAdminService;

    /**
     * 管理员登录
     * @param loginDto
     * @return String
     */
    @PostMapping("/login")
    public Map login(@RequestBody @Valid LoginDto loginDto) {
        log.info(loginDto.toString());
        return sysAdminService.login(loginDto);
    }

    /**
     *     根据id管理员信息
     */
    @GetMapping("/{id}")
    public SysAdmin getSysAdmin(@PathVariable String id) {
        log.info(sysAdminService.getSysAdminById(id).toString());
        return sysAdminService.getSysAdminById(id);
    }
}
