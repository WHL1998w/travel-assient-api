package com.soft1841.travel.api.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.entity.PoiTicket;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.vo.PoiTicketVo;
import com.soft1841.travel.api.mapper.AttractionsInfoMapper;
import com.soft1841.travel.api.service.AttractionsInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-04-24
 */
@Service
public class AttractionsInfoServiceImpl extends ServiceImpl<AttractionsInfoMapper, AttractionsInfo> implements AttractionsInfoService {

    @Resource
    private AttractionsInfoMapper attractionsInfoMapper;

    /**
     * 根据景点id查询景点详情
     * @param poiId
     * @return
     */
    @Override
    public Result getAttractionsById(String poiId) {
        AttractionsInfo attractionsInfo = attractionsInfoMapper.getAttractionsById(poiId);
        if (attractionsInfo != null){
            Map<String, Object> map = new TreeMap<>();
            map.put("PoiId",attractionsInfo.getPoiId());
            map.put("PoiName", attractionsInfo.getPoiName());
            map.put("PoiSummary", attractionsInfo.getPoiSummary());
            map.put("PoiAddress", attractionsInfo.getPoiAddress());
            map.put("PoiTime", attractionsInfo.getPoiTime());
            map.put("PoiTraffic", attractionsInfo.getPoiTraffic());
            map.put("PoiImage", attractionsInfo.getPoiImage());
            map.put("PoiOpenTime", attractionsInfo.getPoiOpenTime());
            map.put("ViewsNumber",attractionsInfo.getViewsNum());

            AttractionsInfo attractionsInfo1 = new AttractionsInfo();
            attractionsInfo1.setViewsNum(attractionsInfo.getViewsNum() + 1);
            UpdateWrapper<AttractionsInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("poi_id",attractionsInfo.getPoiId());
            System.out.println("修改之后的信息"+attractionsInfoMapper.update(attractionsInfo,updateWrapper));


            List<PoiTicketVo> list = new ArrayList<>();
            List<PoiTicket> poiTickets = attractionsInfo.getPoiTicketList();
            System.out.println(poiTickets);
            for (PoiTicket poiTicket : poiTickets) {
                PoiTicketVo poiTicketVo = new PoiTicketVo(poiTicket.getTicket(), poiTicket.getType());
                list.add(poiTicketVo);
            }
            map.put("poiTickets", list);
            return Result.success(map);
        }else {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
    }

    /**
     * 分页查询景点信息
     * @param pageDto
     * @return
     */
    @Override
    public Result getByPage(PageDto pageDto) {
        Page<AttractionsInfo> page = new Page<>(pageDto.getCurrentPage(),pageDto.getPageSize());
        QueryWrapper<AttractionsInfo> wrapper = new QueryWrapper<>();
        IPage<AttractionsInfo> iPage = attractionsInfoMapper.selectPage(page, wrapper);
        return Result.success(iPage);
    }

    /**
     * 模糊查询景点信息（根据景点名称，景点所在地区）
     * @param field
     * @return
     */
    @Override
    public Result blurSelect(String field) {
        QueryWrapper<AttractionsInfo> wrapper = new QueryWrapper<>();
        wrapper.like("poi_name",field).or().like("poi_address",field);
        List<AttractionsInfo> attractionsInfo = attractionsInfoMapper.selectList(wrapper);
        return Result.success(attractionsInfo);
    }

    /**
     * 查询热门景点信息
     * @return
     */
    @Override
    public Result getTopAttrationsInfo() {
        QueryWrapper<AttractionsInfo> wrapper = new QueryWrapper<>();
        wrapper.ge("views_num",2);
        List<AttractionsInfo> attractionsInfos = attractionsInfoMapper.selectList(wrapper);
        return Result.success(attractionsInfos);
    }
}
