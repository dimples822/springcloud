package com.dimples.sys.po;

import lombok.Data;

@Data
public class RoleUser {
    /**
     * 角色职位关联id
     */
    private Long roleUserId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;
}