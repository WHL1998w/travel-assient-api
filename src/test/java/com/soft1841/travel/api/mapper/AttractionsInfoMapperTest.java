package com.soft1841.travel.api.mapper;

import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.PoiTicket;
import com.soft1841.travel.api.domain.entity.SysAdmin;
import com.soft1841.travel.api.domain.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AttractionsInfoMapperTest {
    @Resource
    private AttractionsInfoMapper attractionsInfoMapper;

    @Test
    void getAttractionsById() {
        AttractionsInfo attractionsInfo = attractionsInfoMapper.getAttractionsById("1");
        System.out.println("景点基础信息");
        System.out.println(attractionsInfo.getPoiId());
        System.out.println(attractionsInfo.getPoiName());
        System.out.println(attractionsInfo.getPoiAddress());
        System.out.println("景点门票");
        List<PoiTicket> poiTicketList = attractionsInfo.getPoiTicketList();
        System.out.println(poiTicketList);
        for (PoiTicket poiTicketLists : poiTicketList) {
            System.out.println(poiTicketLists.getPoiId() + ":" + poiTicketLists.getTicket() + ":" + poiTicketLists.getType());
        }
    }

}