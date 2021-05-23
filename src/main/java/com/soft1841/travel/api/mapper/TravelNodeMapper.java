package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.entity.GourmetFood;
import com.soft1841.travel.api.domain.entity.TravelNode;
import com.soft1841.travel.api.domain.vo.TravelNodeVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
public interface TravelNodeMapper extends BaseMapper<TravelNode> {

    /**
     * 根据游记的id查询游记详细信息
     * @param id
     * @return
     */
    TravelNodeVo getTravelNodeById(@Param("id") Integer id);

}
