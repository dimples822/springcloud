package com.dimples.sys.po;

import java.util.Date;
import lombok.Data;

@Data
public class Dept {
    /**
     * 科室id
     */
    private Long deptId;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;
}