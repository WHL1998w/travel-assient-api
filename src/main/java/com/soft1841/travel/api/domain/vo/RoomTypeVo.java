package com.soft1841.travel.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
@Data
@NoArgsConstructor
@Builder
public class RoomTypeVo {

    /**
     * 酒店房型
     */
    @TableField("room_type")
    private String roomType;

    /**
     * 房型价格
     */
    @TableField("room_price")
    private Double roomPrice;

    /**
     * 房间个数
     */
    @TableField("room_num")
    private Integer roomNum;

    public RoomTypeVo(String roomType, Double roomPrice, Integer roomNum) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomNum = roomNum;
    }
}
