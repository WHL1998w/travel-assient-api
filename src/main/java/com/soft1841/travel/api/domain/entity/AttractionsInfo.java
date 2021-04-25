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

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-04-24
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
     * 景点门票
     */
    @TableField("poi_ticket")
    private String poiTicket;

    /**
     * 景点开放时间
     */
    @TableField("poi_open_time")
    private String poiOpenTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
