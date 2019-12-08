package com.dimples.common.vo;

import java.util.Date;

import lombok.Data;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/8
  */
@Data
public class PermissionVo {
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_BUTTON = "button";
    public static final String TYPE_DATA = "data";
    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 菜单URL
     */
    private String permissionUrl;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;

    /**
     * 权限类型，如button，menu
     */
    private String permissionType;

    /**
     * 用户状态，0不启用，1启用，默认为1
     */
    private Byte status;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;
}