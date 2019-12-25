package com.dimples.auth.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 角色信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/25
 */
@Data
public class Role implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

}