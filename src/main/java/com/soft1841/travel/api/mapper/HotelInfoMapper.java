package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.dto.AppointmentHotelDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.HotelInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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

    /**
     * 预约酒店接口
     * @param hotelDto
     */
    @Insert("INSERT INTO user_appointment(name,phone,appointment_name,room_type,accompany_nums,check_in_time,leave_time,remarks,type) values (#{name},#{phone},#{appointmentName},#{roomType},#{accompanyNums},#{checkInTime},#{leaveTime},#{remarks},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertAppoinHtoel(AppointmentHotelDto hotelDto);

}
