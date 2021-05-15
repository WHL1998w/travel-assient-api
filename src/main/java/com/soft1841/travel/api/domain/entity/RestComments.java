package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rest_comments")
public class RestComments extends Model<RestComments> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 餐厅id
     */
    @TableField("restaurant_id")
    private Integer restaurantId;

    /**
     * 点评内容
     */
    @TableField("comments")
    private String comments;
    //关联字段无需注解
    private  String user_name;
    private  String avatar;
    /**
     * 发表点评时间
     */
    @TableField("comments_time")
    private LocalDateTime commentsTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
