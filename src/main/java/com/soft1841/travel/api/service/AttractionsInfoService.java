package com.soft1841.travel.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;

/**
 * <p>
 *  景点信息service服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-04-24
 */
public interface AttractionsInfoService extends IService<AttractionsInfo> {

    /**
     * 根据景点id查询景点详情
     * @param poiId
     * @return
     */
    Result getAttractionsById(String poiId);

    /**
     * 分页查询景点信息
     * @param pageDto
     * @return
     */
    Result getByPage(PageDto pageDto);

    /**
     * 模糊查询景点信息
     * @param field
     * @return
     */
    Result blurSelect(String field);

    /**
     * 查询热门景点信息
     * @return
     */
    Result getTopAttrationsInfo();

    /**
     * 预约景点
     * @param appointmentAttraDto
     * @return
     */
    Result insertAppoinAttration(AppointmentAttraDto appointmentAttraDto);


}
