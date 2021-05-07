package com.soft1841.travel.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1841.travel.api.domain.vo.AttrationsInfoVo;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-04-24
 */
public interface AttractionsInfoService extends IService<AttractionsInfo> {

//    /**
//     * 查询景点详情
//     * @param poiId
//     * @return
//     */
//    AttrationsInfoVo getAttractionsById (String poiId);

    /**
     * 查询景点详情
     * @param poiId
     * @return
     */
    Map<String,Object> getAttractionsById(String poiId);


    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    List<AttractionsInfo> getByPage(int current, int size);

}
