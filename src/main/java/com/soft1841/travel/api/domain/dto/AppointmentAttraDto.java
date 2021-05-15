package com.soft1841.travel.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName
 * @Description 景点预约的实体类
 * @Author wanghuanle
 * @Date
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentAttraDto {
    //主键
    private Integer id;
    //预约人姓名
    private String name;
    //预约人电话
    private String phone;
    //景点名称
    private String appointmentName;
    //随行人数
    private Integer accompanyNums;
    //参观时间
    private Date checkInTime;
    //备注
    private String remarks;

    public AppointmentAttraDto(String name, String phone, String appointmentName, Integer accompanyNums, Date checkInTime, String remarks) {
        this.name = name;
        this.phone = phone;
        this.appointmentName = appointmentName;
        this.accompanyNums = accompanyNums;
        this.checkInTime = checkInTime;
        this.remarks = remarks;
    }
}
