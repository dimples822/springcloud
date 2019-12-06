package com.dimples.sys.po;

import java.util.Date;
import lombok.Data;

@Data
public class UGroup {
    /**
     * 用户组id
     */
    private Long uGroupId;

    /**
     * 用户组名
     */
    private String groupName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;
}