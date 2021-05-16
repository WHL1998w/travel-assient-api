package com.soft1841.travel.api.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.AppointmentHotelDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.HotelInfo;
import com.soft1841.travel.api.domain.entity.PoiTicket;
import com.soft1841.travel.api.domain.entity.RoomType;
import com.soft1841.travel.api.domain.vo.PoiTicketVo;
import com.soft1841.travel.api.domain.vo.RoomTypeVo;
import com.soft1841.travel.api.mapper.HotelInfoMapper;
import com.soft1841.travel.api.service.HotelInfoService;
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
 * @since 2021-05-09
 */
@Service
public class HotelInfoServiceImpl extends ServiceImpl<HotelInfoMapper, HotelInfo> implements HotelInfoService {
    @Resource
    private HotelInfoMapper hotelInfoMapper;

    /**
     * 根据酒店id酒店详细信息
     * @param id
     * @return
     */
    @Override
    public Result getHotelInfoById(Integer id) {
        HotelInfo hotelInfo = hotelInfoMapper.getHotelInfoById(id);
        if (hotelInfo != null){
            Map<String, Object> map = new TreeMap<>();
            map.put("HotelName",hotelInfo.getHotelName());
            map.put("HotelPosition", hotelInfo.getHotelPosition());
            map.put("Price", hotelInfo.getPrice());
            map.put("Star", hotelInfo.getStar());
            map.put("Image", hotelInfo.getImage());
            map.put("Fraction", hotelInfo.getFraction());
            map.put("BasicInfo", hotelInfo.getBasicInfo());
            map.put("Facility", hotelInfo.getFacility());
            map.put("Raiders",hotelInfo.getRaiders());
            List<RoomTypeVo> roomTypeVos = new ArrayList<>();
            List<RoomType> roomTypes = hotelInfo.getRoomTypeList();
            System.out.println(roomTypes);
            for (RoomType roomType : roomTypes) {
                RoomTypeVo roomTypeVo = new RoomTypeVo(roomType.getRoomType(), roomType.getRoomPrice(),roomType.getRoomNum());
                roomTypeVos.add(roomTypeVo);
            }
            map.put("roomTypeVos", roomTypeVos);
            return Result.success(map);

        }else {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
    }

    /**
     * 分页查询酒店信息
     * @param pageDto
     * @return
     */
    @Override
    public Result getByPage(PageDto pageDto) {
        QueryWrapper<HotelInfo> wrapper = new QueryWrapper<>();
        if (pageDto.getCurrentPage() == 0 && pageDto.getPageSize() == 0){
            List<HotelInfo> hotelInfos = hotelInfoMapper.selectList(wrapper);
            return Result.success(hotelInfos);
        }else {
            Page<HotelInfo> page = new Page<>(pageDto.getCurrentPage(),pageDto.getPageSize());
            IPage<HotelInfo> iPage = hotelInfoMapper.selectPage(page, wrapper);
            return Result.success(iPage);
        }
    }

    /**
     * 模糊查询酒店信息
     * @param field
     * @return
     */
    @Override
    public Result blurSelect(String field) {
        QueryWrapper<HotelInfo> wrapper = new QueryWrapper<>();
        wrapper.like("hotel_name",field).or().like("hotel_position",field);
        List<HotelInfo> hotelInfos = hotelInfoMapper.selectList(wrapper);
        return Result.success(hotelInfos);
    }

    /**
     * 查询热门酒店信息
     * @return
     */
    @Override
    public Result getTopHotelsInfo() {
        QueryWrapper<HotelInfo> wrapper = new QueryWrapper<>();
        wrapper.ge("fraction","8.5分");
        List<HotelInfo> hotelInfos = hotelInfoMapper.selectList(wrapper);
        return Result.success(hotelInfos);
    }

    /**
     * 预约酒店
     * @param hotelDto
     * @return
     */
    @Override
    public Result insertAppoinHotel(AppointmentHotelDto hotelDto) {
        hotelInfoMapper.insertAppoinHtoel(hotelDto);
        return Result.success(hotelDto);
    }
}
