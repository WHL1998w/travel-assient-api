package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.entity.GourmetFood;
import com.soft1841.travel.api.domain.entity.HotelInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  美食Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface GourmetFoodMapper extends BaseMapper<GourmetFood> {

    /**
     * 根据美食餐厅的id查询餐厅详细信息
     * @param id
     * @return
     */
    GourmetFood getGourmetFoodById(@Param("id") Integer id);

}
