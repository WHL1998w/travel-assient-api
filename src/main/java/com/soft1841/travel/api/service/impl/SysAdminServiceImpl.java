package com.soft1841.travel.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.AdminDto;
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
import java.util.*;

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
        // 查询基础信息，主要是要用密码来判定
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

    @Override
    public Map<String, Object> loginWechat(LoginDto loginWechatDto) {
        //根据管理员昵称查到基础信息，主要是要用密码来判定
        SysAdmin admin = sysAdminMapper.selectByName(loginWechatDto.getName());
        if (admin != null) {
            //客户端密码加密后和数据库的比对
            String pass = Md5Util.getMd5(loginWechatDto.getPassword(), true, 32);
            if (admin.getPassword().equals(pass)) {
                //登录成功，取得admin的完整信息
                SysAdmin admin1 = sysAdminMapper.selectByName(loginWechatDto.getName());
                //通过该管理员的id、私钥、指定过期时间生成token
                String token = JwtTokenUtil.getToken1(admin.getId(), admin.getSalt(), new Date(System.currentTimeMillis() + 6000L * 1000L));
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
     * @param
     * @return
     */
    @Override
    public Result updateSysAdmin(AdminDto adminDto) {
        SysAdmin sysAdmin = new SysAdmin();
        //根据管理员账号查询管理员信息
        sysAdmin = sysAdminMapper.getSysAdminByName(adminDto.getAccount());
        if (sysAdmin != null){
            sysAdmin.setPassword(Md5Util.getMd5(adminDto.getPassword(),true,32));
            sysAdmin.setAccount(adminDto.getAccount());
            sysAdmin.setAvatar(adminDto.getAvatar());
            sysAdminMapper.updateById(sysAdmin);
        }else {
            return Result.failure(ResultCode.USER_NOT_FOUND);
        }
        return Result.success(sysAdmin);
    }

    /**
     * 新增管理员admin
     */
    @Override
    public Result insertAdmin(AdminDto adminDto) {
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId(UUID.randomUUID().toString());
        sysAdmin.setAccount(adminDto.getAccount());
        sysAdmin.setAvatar(adminDto.getAvatar());
        sysAdmin.setPassword(Md5Util.getMd5(adminDto.getPassword(),true,32));
        sysAdmin.setSalt("1");
        sysAdminMapper.insertAdmin(sysAdmin.getId(),sysAdmin.getAccount(),sysAdmin.getPassword(),sysAdmin.getAvatar(),sysAdmin.getSalt());
        return Result.success(sysAdmin);
    }

    @Override
    public Result deleteAdmin(SysAdmin sysAdmin) {
        sysAdminMapper.deleteAdmin(sysAdmin.getAccount());
        return Result.success();
    }
}
