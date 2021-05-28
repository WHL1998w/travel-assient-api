package com.soft1841.travel.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName
 * @Description 预约酒店实体类
 * @Author wanghuanle
 * @Date
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentHotelDto {
    //主键
    private Integer id;
    //预约人姓名
    private String name;
    //预约人手机号
    private String phone;
    //酒店名称
    private String appointmentName;
    //房间类型
    private String roomType;
    //随行人数
    private Integer accompanyNums;
    //入住时间
    private String checkInTime;
    //离店时间
    private String leaveTime;
    //备注
    private String remarks;
    //预约类型
    private Integer type;
    //用户id
    private Integer userId;
}
