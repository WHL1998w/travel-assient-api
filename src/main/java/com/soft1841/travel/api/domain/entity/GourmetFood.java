package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gourmet_food")
public class GourmetFood extends Model<GourmetFood> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    /**
     * 餐馆名称
     */
    @TableField("restaurant_name")
    private String restaurantName;

    /**
     * 位置
     */
    @TableField("position")
    private String position;

    /**
     * 评分
     */
    @TableField("score")
    private Double score;

    /**
     * 点评人数
     */
    @TableField("reviews_num")
    private Integer reviewsNum;

    /**
     * 图片
     */
    @TableField("image")
    private String image;

    /**
     * 餐厅简介
     */
    @TableField("introduction")
    private String introduction;

    /**
     * 交通
     */
    @TableField("traffic")
    private String traffic;

    /**
     * 人均消费
     */
    @TableField("consumption")
    private Double consumption;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
