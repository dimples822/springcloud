package com.dimples.common.result;

import com.alibaba.fastjson.JSONObject;
import com.dimples.common.eunm.CodeAndMessageEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用返回结果类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/1
 */
@SuppressWarnings("unchecked")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultCommon<T> {

    @Setter
    @Getter
    private Integer code;

    @Setter
    @Getter
    private String msg;

    @Setter
    @Getter
    private T data;

    public ResultCommon() {

    }

    public ResultCommon(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultCommon(CodeAndMessageEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
        this.data = data;
    }

    /**
     * 此构造方法在全局异常处理器中用到
     *
     * @param code 异常的状态码，如：401（身份验证失败）、500（服务器内部错误）
     * @param msg  异常的提示信息
     */
    public ResultCommon(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCommon(CodeAndMessageEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    /**
     * 成功但不带数据
     **/
    public static ResultCommon success() {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        return result;
    }

    public static ResultCommon success(Object object) {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 泛型数据返回
     *
     * @param object T
     * @return ResultCommon<T>
     */
    public ResultCommon<T> ok(T object) {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }


    public static ResultCommon success(CodeAndMessageEnum resultCodeEnum, Object object) {
        ResultCommon result = new ResultCommon();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 失败
     **/
    public static ResultCommon error(Integer code, String msg) {
        ResultCommon result = new ResultCommon();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResultCommon error(String message) {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.SERVER_ERROR.getCode());
        result.setMsg(message);
        return result;
    }

    public static ResultCommon error(CodeAndMessageEnum resultCodeEnum) {
        ResultCommon result = new ResultCommon();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 操作失败
     *
     * @return ResultCommon
     */
    public static ResultCommon failed() {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.FAIL.getCode());
        result.setMsg(CodeAndMessageEnum.FAIL.getMessage());
        return result;
    }

    public static ResultCommon failed(String msg) {
        ResultCommon result = new ResultCommon();
        result.setCode(CodeAndMessageEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public static ResultCommon failed(CodeAndMessageEnum resultCodeEnum) {
        ResultCommon result = new ResultCommon();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 设置响应
     *
     * @param response    HttpServletResponse
     * @param contentType content-type
     * @param status      http状态码
     * @param value       响应内容
     * @throws IOException IOException
     */
    public static void makeResponse(HttpServletResponse response, String contentType,
                                    int status, Object value) throws IOException {
        response.setContentType(contentType);
        response.setStatus(status);
        response.getOutputStream().write(JSONObject.toJSONString(value).getBytes());
    }

}














