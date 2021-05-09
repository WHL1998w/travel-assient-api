package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("attractions_info")
public class AttractionsInfo extends Model<AttractionsInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 景点id
     */
    @TableField("poi_id")
    private String poiId;

    /**
     * 景点名称
     */
    @TableField("poi_name")
    private String poiName;

    /**
     * 景点介绍
     */
    @TableField("poi_summary")
    private String poiSummary;

    /**
     * 景点位置
     */
    @TableField("poi_address")
    private String poiAddress;

    /**
     * 景点游览时间
     */
    @TableField("poi_time")
    private String poiTime;

    /**
     * 景点交通
     */
    @TableField("poi_traffic")
    private String poiTraffic;

    /**
     * 景点图片
     */
    @TableField("poi_image")
    private String poiImage;

    /**
     * 景点开放时间
     */
    @TableField("poi_open_time")
    private String poiOpenTime;

    /**
     * 景点浏览量
     */
    @TableField("views_num")
    private Integer viewsNum;

    @JsonIgnore
    @TableField(exist = false) //数据库不存在的字段
    private List<PoiTicket> poiTicketList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
