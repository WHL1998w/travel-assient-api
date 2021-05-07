package com.soft1841.travel.api.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.domain.entity.PoiTicket;
import com.soft1841.travel.api.domain.entity.SysMenu;
import com.soft1841.travel.api.domain.entity.SysRole;
import com.soft1841.travel.api.domain.vo.AttrationsInfoVo;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.vo.PoiTicketVo;
import com.soft1841.travel.api.mapper.AttractionsInfoMapper;
import com.soft1841.travel.api.mapper.PoiTicketMapper;
import com.soft1841.travel.api.service.AttractionsInfoService;
import com.soft1841.travel.api.util.TreeBuilder;
import com.soft1841.travel.api.util.TreeNode;
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



    @Override
    public Map<String, Object> getAttractionsById(String poiId) {
        AttractionsInfo attractionsInfo = attractionsInfoMapper.getAttractionsById(poiId);
        Map<String, Object> map = new TreeMap<>();
        map.put("PoiName", attractionsInfo.getPoiName());
        map.put("PoiSummary", attractionsInfo.getPoiSummary());
        map.put("PoiAddress", attractionsInfo.getPoiAddress());
        map.put("PoiTime", attractionsInfo.getPoiTime());
        map.put("PoiTraffic", attractionsInfo.getPoiTraffic());
        map.put("PoiImage", attractionsInfo.getPoiImage());
        map.put("PoiOpenTime", attractionsInfo.getPoiOpenTime());

        List<PoiTicketVo> list = new ArrayList<>();
        List<PoiTicket> poiTickets = attractionsInfo.getPoiTicketList();
        System.out.println(poiTickets);
        for (PoiTicket poiTicket : poiTickets) {
            PoiTicketVo poiTicketVo = new PoiTicketVo(poiTicket.getTicket(), poiTicket.getType());
            list.add(poiTicketVo);
        }
        map.put("poiTickets", list);
        return map;
    }

    @Override
    public List<AttractionsInfo> getByPage(int current, int size) {
        Page<AttractionsInfo> page = new Page<>(current, size);
        QueryWrapper<AttractionsInfo> wrapper = new QueryWrapper<>();
        IPage<AttractionsInfo> iPage = attractionsInfoMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }
}
