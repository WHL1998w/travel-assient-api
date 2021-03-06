package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.soft1841.travel.api.domain.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SysAdminMapperTest {
    @Resource
    private SysAdminMapper sysAdminMapper;

    @Test
    void selectByName() {
        SysAdmin sysAdmin = sysAdminMapper.selectByName("wanghuanle");
        System.out.println("admin基础信息");
        System.out.println(sysAdmin.getId());
        System.out.println(sysAdmin.getAccount());
        System.out.println(sysAdmin.getAvatar());
        System.out.println("他的所有角色");
        List<SysRole> roles = sysAdmin.getRoles();
        System.out.println(roles);
        for (SysRole role : roles) {
            System.out.println(role.getRoleId() + ":" + role.getRoleName());
        }
    }

    @Test
    void getSysAdminByName() {
    }

    @Test
    void getSysAdminById() {
    }

    @Test
    void insertAdmin() {

    }
}