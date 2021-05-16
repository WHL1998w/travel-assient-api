package com.soft1841.travel.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.dto.AppointmentGourmetFoodDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.dto.RestCommentsDto;
import com.soft1841.travel.api.domain.entity.GourmetFood;

/**
 * <p>
 *  美食服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface GourmetFoodService extends IService<GourmetFood> {

    /**
     * 根据餐厅id查询餐厅详细信息
     * @param id
     * @return
     */
    Result getGourmentFoodById(Integer id);

    /**
     * 分页查询餐厅信息
     * @param pageDto
     * @return
     */
    Result getByPage(PageDto pageDto);

    /**
     * 模糊查询餐厅
     * @param field
     * @return
     */
    Result blurSelect(String field);

    /**
     * 热门美食查询接口
     * @return
     */
    Result getTopGourmentFood();

    /**
     * 预约餐厅
     * @param foodDto
     * @return
     */
    Result insertAppoinFood(AppointmentGourmetFoodDto foodDto);

    /**
     * 点评餐厅
     * @param commentsDto
     * @return
     */
    Result insertComments(RestCommentsDto commentsDto);
}
