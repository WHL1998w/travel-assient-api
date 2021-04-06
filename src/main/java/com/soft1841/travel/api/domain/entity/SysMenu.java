package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单级别
     */
    @TableField("menu_grade")
    private Integer menuGrade;

    /**
     * 父级
     */
    @TableField("parent")
    private Integer parent;

    /**
     * 菜单图标
     */
    @TableField("menu_icon")
    private String menuIcon;

    /**
     * 菜单路径地址
     */
    @TableField("router")
    private String router;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
