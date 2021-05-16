package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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


    /**
     * 预约景点接口
     * @param appointmentAttraDto
     */
    @Insert("INSERT INTO user_appointment(name,phone,appointment_name,accompany_nums,check_in_time,remarks,type) values (#{name},#{phone},#{appointmentName},#{accompanyNums},#{checkInTime},#{remarks},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertAppoinAttrations(AppointmentAttraDto appointmentAttraDto);
}
