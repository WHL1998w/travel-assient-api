package com.soft1841.travel.api.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1841.travel.api.domain.dto.AppointmentGourmetFoodDto;
import com.soft1841.travel.api.domain.dto.AppointmentHotelDto;
import com.soft1841.travel.api.domain.dto.RestCommentsDto;
import com.soft1841.travel.api.domain.entity.GourmetFood;
import com.soft1841.travel.api.domain.entity.HotelInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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

    /**
     * 预约餐厅接口
     * @param foodDto
     */
    @Insert("INSERT INTO user_appointment(name,phone,appointment_name,accompany_nums,check_in_time,remarks,type) values (#{name},#{phone},#{appointmentName},#{accompanyNums},#{checkInTime},#{remarks},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertAppoinGourmetFood(AppointmentGourmetFoodDto foodDto);

    /**
     * 点评餐厅接口
     * @param commentsDto
     */
    @Insert("INSERT INTO rest_comments(user_id,restaurant_id,comments,comments_time) values (#{userId},#{restaurantId},#{comments},#{commentsTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertComments(RestCommentsDto commentsDto);

}
