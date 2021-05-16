package com.soft1841.travel.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName
 * @Description 预约餐厅
 * @Author wanghuanle
 * @Date
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentGourmetFoodDto {
    //主键
    private Integer id;
    //预约人姓名
    private String name;
    //预约人手机号
    private String phone;
    //餐厅名称
    private String appointmentName;
    //随行人数
    private Integer accompanyNums;
    //到店时间时间
    private Date checkInTime;
    //备注
    private String remarks;
    //预约类型
    private Integer type;
}
