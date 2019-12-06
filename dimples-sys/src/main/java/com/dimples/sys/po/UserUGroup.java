package com.dimples.sys.po;

import lombok.Data;

@Data
public class UserUGroup {
    /**
     * 用户与用户组关联id
     */
    private Long userUGroupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户组id
     */
    private Integer uGroupId;
}