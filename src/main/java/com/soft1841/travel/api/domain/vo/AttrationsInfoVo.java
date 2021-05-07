package com.soft1841.travel.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.soft1841.travel.api.domain.entity.PoiTicket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttrationsInfoVo {

    private Integer id;

    /**
     * 景点id
     */
    private String poiId;

    /**
     * 景点名称
     */
    private String poiName;

    /**
     * 景点介绍
     */
    private String poiSummary;

    /**
     * 景点位置
     */
    private String poiAddress;

    /**
     * 景点游览时间
     */
    private String poiTime;

    /**
     * 景点交通
     */
    private String poiTraffic;

    /**
     * 景点图片
     */
    private String poiImage;

    /**
     * 景点开放时间
     */
    private String poiOpenTime;

    /**
     * 票价
     */
    private List<PoiTicket> poiTicketList;

    public AttrationsInfoVo(Integer id, String poiId, Double ticket, Integer type) {
    }

    public AttrationsInfoVo(Integer id, String poiId, String poiName, String poiSummary, String poiAddress, String poiTime, String poiTraffic, String poiImage, String poiOpenTime) {
        this.id = id;
        this.poiId = poiId;
        this.poiName = poiName;
        this.poiSummary = poiSummary;
        this.poiAddress = poiAddress;
        this.poiTime = poiTime;
        this.poiTraffic = poiTraffic;
        this.poiImage = poiImage;
        this.poiOpenTime = poiOpenTime;
    }
}
