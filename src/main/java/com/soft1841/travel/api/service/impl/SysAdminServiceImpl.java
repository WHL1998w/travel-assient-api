package com.soft1841.travel.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.LoginDto;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.soft1841.travel.api.domain.entity.SysRole;
import com.soft1841.travel.api.exception.CustomException;
import com.soft1841.travel.api.mapper.SysAdminMapper;
import com.soft1841.travel.api.service.RedisService;
import com.soft1841.travel.api.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.util.JwtTokenUtil;
import com.soft1841.travel.api.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
@Service
@Slf4j
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {

    @Resource
    private SysAdminMapper sysAdminMapper;
    @Resource
    private RedisService redisService;

    //登录功能
    @Override
    public Map<String, Object> login(LoginDto loginDto) {
        //根据查到基础信息，主要是要用密码来判定
        SysAdmin admin = sysAdminMapper.getSysAdminByName(loginDto.getName());
        if (admin != null) {
            //客户端密码加密后和数据库的比对
            String pass = Md5Util.getMd5(loginDto.getPassword(), true, 32);
            if (admin.getPassword().equals(pass)) {
                //登录成功，取得admin的完整信息（包含所有角色）
                SysAdmin admin1 = sysAdminMapper.selectByName(loginDto.getName());
                //roles是个list，可能会是多个
                List<SysRole> roles = admin1.getRoles();
                String roleString = JSONObject.toJSONString(roles);
                log.info("管理员角色列表：" + roleString);
                //通过该管理员的id、roles、私钥、指定过期时间生成token
                String token = JwtTokenUtil.getToken(admin.getId(), JSONObject.toJSONString(roles),admin.getSalt(), new Date(System.currentTimeMillis() + 6000L * 1000L));
                //将私钥存入redis，在后面JWT拦截器中可以取出来对客户端请求头中的token解密
                redisService.set(admin1.getId(), admin1.getSalt(), 100L);
                Map<String, Object> map = new TreeMap<>();
                map.put("admin", admin1);
                map.put("token", token);
                return map;
            } else {
                log.error("密码错误");
                throw new CustomException("密码错误", ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            log.error("用户名不存在");
            throw new CustomException("用户名不存在", ResultCode.USER_NOT_FOUND);
        }
    }

    //根据账号查找admin信息，包括角色信息
    @Override
    public SysAdmin getAdminAndRolesByName(String account) {
        return sysAdminMapper.selectByName(account);
    }

    /**
     * 为指定的管理员生成token
     * @param adminId
     * @param roles
     * @param secrect
     * @param expiresAt
     * @return
     */
    @Override
    public String getToken(String adminId, String roles, String secrect, Date expiresAt) {
        return JwtTokenUtil.getToken(adminId, roles, secrect, expiresAt);
    }

    /**
     * 修改密码
     * @param sysAdmin
     * @return
     */
    @Override
    public SysAdmin updateSysAdmin(SysAdmin sysAdmin) {
        SysAdmin sysAdmin1=sysAdminMapper.getSysAdminById(sysAdmin.getId());
        sysAdmin1.setPassword(Md5Util.getMd5(sysAdmin.getPassword(),true,32));
        sysAdmin1.setAccount(sysAdmin.getAccount());
        sysAdmin1.setAvatar(sysAdmin.getAvatar());
        sysAdminMapper.updateById(sysAdmin1);
        return sysAdmin1;
    }

    //根据id查找用户信息
    @Override
    public SysAdmin getSysAdminById(String id) {
        return sysAdminMapper.getSysAdminById(id);
    }
}
