package com.dimples.sys.po;

import lombok.Data;

@Data
public class RolePosition {
    /**
     * 用户角色关联id
     */
    private Long rolePositionId;

    /**
     * 职位id
     */
    private Long positionId;

    /**
     * 角色id
     */
    private Long roleId;
}