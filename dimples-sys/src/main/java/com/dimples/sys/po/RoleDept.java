package com.dimples.sys.po;

import lombok.Data;

@Data
public class RoleDept {
    /**
     * 角色科室关联id
     */
    private Long roleDeptId;

    /**
     * 科室id
     */
    private Long deptId;

    /**
     * 角色id
     */
    private Long roleId;
}