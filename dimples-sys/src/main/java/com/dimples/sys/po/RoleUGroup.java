package com.dimples.sys.po;

import lombok.Data;

@Data
public class RoleUGroup {
    /**
     * 角色用户组关联id
     */
    private Long roleUGroupId;

    /**
     * 用户组id
     */
    private Long uGroupId;

    /**
     * 角色id
     */
    private Long roleId;
}