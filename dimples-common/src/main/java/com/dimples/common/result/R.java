package com.dimples.common.result;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class R<T> {

    @Setter
    @Getter
    private Integer code;

    @Setter
    @Getter
    private String msg;

    @Setter
    @Getter
    private T data;

    public R() {

    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(CodeAndMessageEnum resultCodeEnum, T data) {
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
    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(CodeAndMessageEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    /**
     * 成功但不带数据
     **/
    public static R success() {
        R result = new R();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        return result;
    }

    public static R success(Object object) {
        R result = new R();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 泛型数据返回
     *
     * @param object T
     * @return R<T>
     */
    public R<T> ok(T object) {
        R result = new R();
        result.setCode(CodeAndMessageEnum.SUCCESS.getCode());
        result.setMsg(CodeAndMessageEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }


    public static R success(CodeAndMessageEnum resultCodeEnum, Object object) {
        R result = new R();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 失败
     **/
    public static R error(Integer code, String msg) {
        R result = new R();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static R error(String message) {
        R result = new R();
        result.setCode(CodeAndMessageEnum.SERVER_ERROR.getCode());
        result.setMsg(message);
        return result;
    }

    public static R error(CodeAndMessageEnum resultCodeEnum) {
        R result = new R();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 操作失败
     *
     * @return R
     */
    public static R failed() {
        R result = new R();
        result.setCode(CodeAndMessageEnum.FAIL.getCode());
        result.setMsg(CodeAndMessageEnum.FAIL.getMessage());
        return result;
    }

    public static R failed(String msg) {
        R result = new R();
        result.setCode(CodeAndMessageEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public R<T> fail(String msg) {
        R result = new R();
        result.setCode(CodeAndMessageEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public static R failed(CodeAndMessageEnum resultCodeEnum) {
        R result = new R();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        return result;
    }

}














