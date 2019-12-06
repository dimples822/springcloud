package com.dimples.sys.po;

import java.util.Date;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/27
 */
@Data
public class Template {
    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 模板描述
     */
    private String templateDesc;

    /**
     * 模板类型
     */
    private String templateType;

    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;
}