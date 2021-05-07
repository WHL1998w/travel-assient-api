package com.soft1841.travel.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
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
public class PoiTicketVo {

    /**
     * 门票价格
     */
    private Double ticket;

    /**
     * 门票类型，0：成人票，1：儿童票，2：学生票
     */
    private Integer type;

    public PoiTicketVo(Double ticket, Integer type) {
        this.ticket = ticket;
        this.type = type;
    }
}
