package com.sprig.cloud.common.result;

import lombok.Getter;

/**
 * 业务通用异常代码
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/10/23
 */
@Getter
public enum ResultCode {

    /**
     * 操作成功
     */
    SUCCESS("0000", "success"),
    /**
     * 系统内部错误
     */
    SERVER_ERROR("9999", "system error"),
    /**
     * 请求错误
     */
    REQUEST_ERROR("400", "请求错误"),
    /**
     * 授权失败
     */
    UNAUTHORIZED("401", "未授权"),
    /**
     * 不可访问
     */
    NOT_ACCESSIBLE("403", "不可访问"),
    /**
     * 方法不被允许
     */
    METHOD_NOT_ALLOWED("405", "方法不被允许"),
    /**
     * 不支持当前媒体类型
     */
    UNSUPPORTED_MEDIA_TYPE("415", "不支持当前媒体类型"),

    /**
     * 您的登录令牌已失效，请重新登录
     */
    TOKEN_LOSE_EFFICACY("1001", "您的登录令牌已失效，请重新登录");

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCode getByCode(String code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }

        return null;
    }

}
