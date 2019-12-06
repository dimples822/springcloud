package com.dimples.sys.po;

import lombok.Data;

@Data
public class PermissionRole {
    /**
     * 权限角色关联id
     */
    private Long permissionRoleId;

    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 角色id
     */
    private Long roleId;
}