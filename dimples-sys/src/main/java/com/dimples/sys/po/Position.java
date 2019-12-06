package com.dimples.sys.po;

import java.util.Date;
import lombok.Data;

@Data
public class Position {
    /**
     * 职位id
     */
    private Long positionId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;
}