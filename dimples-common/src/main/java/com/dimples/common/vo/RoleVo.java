package com.dimples.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 角色信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 2179037393108205286L;
    private Long roleId;

    private String roleName;

    private String value;

    private String tips;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
