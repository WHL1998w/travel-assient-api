package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@TableName("hotel_info")
public class HotelInfo extends Model<HotelInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 酒店名称
     */
    @TableField("hotel_name")
    private String hotelName;

    /**
     * 酒店位置
     */
    @TableField("hotel_position")
    private String hotelPosition;

    /**
     * 价格
     */
    @TableField("price")
    private Double price;

    /**
     * 酒店星级
     */
    @TableField("star")
    private String star;

    /**
     * 酒店图片
     */
    @TableField("image")
    private String image;

    /**
     * 酒店评价分数
     */
    @TableField("fraction")
    private String fraction;

    /**
     * 酒店基本信息
     */
    @TableField("basic_info")
    private String basicInfo;

    /**
     * 酒店设施
     */
    @TableField("facility")
    private String facility;

    /**
     * 酒店攻略
     */
    @TableField("raiders")
    private String raiders;

    //房间类型
    @JsonIgnore
    @TableField(exist = false) //数据库不存在的字段
    private List<RoomType> roomTypeList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
