package com.soft1841.travel.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName LoginDto
 * @Description 登录dto
 * @Author wanghuanle
 * @Date 2021/3/8
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @Size(max = 15,message = "用户名不能大于15位")
    @NotNull(message = "姓名不能为空")
    private String name;
    @Size(min = 6,max = 16,message = "密码不能小于6位大于16位")
    @NotNull(message = "密码不能为空")
    private String password;
    @Size(min = 4,max = 6,message = "验证码输入有误")
    @NotNull(message = "验证码不能为空")
    private String verifyCode;
}
