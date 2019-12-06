package com.dimples.sys.po;

import lombok.Data;

@Data
public class UserDept {
    /**
     * 用户科室关联id
     */
    private Long userDeptId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 科室id
     */
    private Long deptId;
}