package com.dimples.sys.po;

import lombok.Data;

@Data
public class UserPosition {
    /**
     * 用户职位关联id
     */
    private Long userPositionId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 职位id
     */
    private Long positionId;
}