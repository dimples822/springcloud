package com.dimples.sys.po;

import lombok.Data;

@Data
public class TemplatePosition {
    private Long templatePositionId;

    /**
    * 模板id
    */
    private Long templateId;

    /**
    * 职位id
    */
    private Long positionId;
}