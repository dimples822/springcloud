package com.dimples.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

import lombok.Data;

/**
 * 权限信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVo {
    private Integer id;
    private String code;
    private String pCode;
    private String pId;
    private String name;
    private String url;
    private Integer isMenu;
    private Integer level;
    private Integer sort;
    private Integer status;
    private String icon;
    private Date createTime;
    private Date updateTime;
}
