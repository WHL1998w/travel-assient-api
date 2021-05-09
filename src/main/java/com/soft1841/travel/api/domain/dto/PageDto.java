package com.soft1841.travel.api.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName PageDto
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/25
 **/
@Data
@Builder
public class PageDto {
//    private Object field;
    private int currentPage;
    private int pageSize;
}