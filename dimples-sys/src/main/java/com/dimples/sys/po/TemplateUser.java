package com.dimples.sys.po;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/28
 */
@Data
public class TemplateUser {
    private Long templateUserId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 模板是否激活使用（1为激活，0为不激活，默认为0）
     * 对于一个用户来说，在同一个类型的模板中，一个用户最多只能激活一个模板
     */
    private String active;
}












