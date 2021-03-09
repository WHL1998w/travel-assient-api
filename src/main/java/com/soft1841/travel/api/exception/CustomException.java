package com.soft1841.travel.api.exception;


import com.soft1841.travel.api.common.ResultCode;

/**
 * @ClassName CustomException
 * @Description 用户自定义异常
 * @Author wanghuanle
 * @Date 2021/03/08
 * @Version 1.0
 */
public class CustomException extends RuntimeException {
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
