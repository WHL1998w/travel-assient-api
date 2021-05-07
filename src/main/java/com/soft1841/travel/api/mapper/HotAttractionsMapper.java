package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.HotAttractions;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  热门景点 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface HotAttractionsMapper extends BaseMapper<HotAttractions> {

    /**
     * 根据热门景点id查询景点信息
     * @param id
     * @return
     */

    AttractionsInfo getHotAttrationsInfo(@Param("id") Integer id);


}
