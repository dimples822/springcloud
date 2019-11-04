package com.sprig.cloud.common.result;

import lombok.Data;

/**
 * 通用返回类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/10/23
 */
@Data
public class Result {

    private static final String SUCCESS_MESSAGE = "success";

    /**
     * 0000为返回正常， 其它code均为请求错误
     */
    private String code;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String message;

    private Result() {

    }

    private Result(Object data) {
        this();
        this.data = data;
    }

    private Result(String message) {
        this.code = "9999";
        this.message = message;
    }

    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

}
















