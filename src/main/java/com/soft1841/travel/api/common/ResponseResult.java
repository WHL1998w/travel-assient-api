package com.soft1841.travel.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wanghuanle
 * @ClassName  ResponseResult
 * @description 返回的JSON数据结构标准
 * @create 2020/2/5
 */
@Data
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

}