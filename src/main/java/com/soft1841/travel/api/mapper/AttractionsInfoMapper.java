package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  景点详情Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface AttractionsInfoMapper extends BaseMapper<AttractionsInfo> {

     /**
      * 根据景点id景点详细信息，包括票价
      * @param poiId
      * @return
      */
    AttractionsInfo getAttractionsById(@Param("poiId") String poiId);

}
