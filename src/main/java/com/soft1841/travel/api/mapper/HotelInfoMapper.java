package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.HotelInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface HotelInfoMapper extends BaseMapper<HotelInfo> {

    /**
     * 根据酒店id酒店详细信息，包括房间价格
     * @param id
     * @return
     */
    HotelInfo getHotelInfoById(@Param("id") Integer id);

}
