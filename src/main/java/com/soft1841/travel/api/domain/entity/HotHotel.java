package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("hot_hotel")
public class HotHotel extends Model<HotHotel> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    /**
     * 酒店id
     */
    @TableField("hotel_id")
    private Integer hotelId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
