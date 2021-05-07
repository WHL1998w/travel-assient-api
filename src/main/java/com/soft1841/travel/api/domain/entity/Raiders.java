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
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("raiders")
public class Raiders extends Model<Raiders> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 攻略的标题
     */
    @TableField("raiders_title")
    private String raidersTitle;

    /**
     * 攻略的封面
     */
    @TableField("raiders_cover")
    private String raidersCover;

    /**
     * 攻略的描述
     */
    @TableField("raiders_description")
    private String raidersDescription;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 浏览的次数
     */
    @TableField("raiders_views")
    private String raidersViews;

    /**
     * 评论次数
     */
    @TableField("raiders_comment")
    private String raidersComment;

    /**
     * 攻略的来源
     */
    @TableField("raiders_source")
    private String raidersSource;

    /**
     * 出发的时间
     */
    @TableField("departure_time")
    private LocalDateTime departureTime;

    /**
     * 出行的天数
     */
    @TableField("travel_days")
    private String travelDays;

    /**
     * 人均费用
     */
    @TableField("per_capita_cost")
    private String perCapitaCost;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
