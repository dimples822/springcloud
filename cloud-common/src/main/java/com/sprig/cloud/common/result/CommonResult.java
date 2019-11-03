package com.sprig.cloud.common.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共返回类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/10/23
 */
public class CommonResult extends HashMap<String, Object> implements Serializable {

    private static final String CODE = "Code";
    private static final String MSG = "Message";

    private CommonResult() {
        put(CODE, 0);
        put(MSG, "success");
    }

    public static CommonResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static CommonResult error(String msg) {
        return error(500, msg);
    }

    public static CommonResult error(int code, String msg) {
        CommonResult r = new CommonResult();
        r.put(CODE, code);
        r.put(MSG, msg);
        return r;
    }

    public static CommonResult success(String msg) {
        CommonResult r = new CommonResult();
        r.put(MSG, msg);
        return r;
    }

    public static CommonResult success(Map<String, Object> map) {
        CommonResult r = new CommonResult();
        r.putAll(map);
        return r;
    }

    public static CommonResult success() {
        return new CommonResult();
    }

    @Override
    public CommonResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
