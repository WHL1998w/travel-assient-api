package com.soft1841.travel.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.dto.TravelNodeDto;
import com.soft1841.travel.api.domain.entity.TravelNode;

/**
 * <p>
 *  游记服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface TravelNodeService extends IService<TravelNode> {

    /**
     * 根据游记id查询游记详细信息
     * @param id
     * @return
     */
    Result getTravelNodeById(Integer id);

    /**
     * 分页查询游记信息
     * @param pageDto
     * @return
     */
    Result getByPage(PageDto pageDto);

    /**
     * 模糊查询游记信息
     * @param field
     * @return
     */
    Result blurSelect(String field);

    /**
     * 查询热门游记信息
     * @return
     */
    Result getTopTravelNodeInfo();

    /**
     * 发表游记
     * @param travelNodeDto
     * @return
     */
    Result addTravelNode(TravelNodeDto travelNodeDto);
}
