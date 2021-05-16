package com.soft1841.travel.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.dto.AppointmentHotelDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.HotelInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface HotelInfoService extends IService<HotelInfo> {

    /**
     * 根据酒店id酒店详情
     * @param id
     * @return
     */
    Result getHotelInfoById(Integer id);

    /**
     * 分页查询酒店信息
     * @param pageDto
     * @return
     */
    Result getByPage(PageDto pageDto);

    /**
     * 模糊查询酒店信息
     * @param field
     * @return
     */
    Result blurSelect(String field);

    /**
     * 查询热门酒店信息
     * @return
     */
    Result getTopHotelsInfo();

    /**
     * 预约酒店
     * @param hotelDto
     * @return
     */
    Result insertAppoinHotel(AppointmentHotelDto hotelDto);

}
