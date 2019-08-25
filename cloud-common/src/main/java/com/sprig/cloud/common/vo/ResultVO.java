package com.sprig.cloud.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.ToString;

/**
 * 接口公共返回类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/14
 */
@ToString
public class ResultVO extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 3086724473347652113L;

    private static final String CODE = "code";
    private static final String MSG = "msg";

    public ResultVO() {
        put(CODE, 0);
        put(MSG, "success");
    }

    public static ResultVO error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultVO error(String msg) {
        return error(500, msg);
    }

    public static ResultVO error(int code, String msg) {
        ResultVO r = new ResultVO();
        r.put(CODE, code);
        r.put(MSG, msg);
        return r;
    }

    public static ResultVO success(String msg) {
        ResultVO r = new ResultVO();
        r.put(MSG, msg);
        return r;
    }

    public static ResultVO success(Map<String, Object> map) {
        ResultVO r = new ResultVO();
        r.putAll(map);
        return r;
    }

    public static ResultVO success() {
        return new ResultVO();
    }

    @Override
    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
