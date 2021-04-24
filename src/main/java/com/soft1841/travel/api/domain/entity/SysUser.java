package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @ClassName
 * @Description 用户实体类
 * @Author wanghuanle
 * @Date
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser {
    private Integer id;
    private String userName;
    private String phone;
    private String avatar;
}
