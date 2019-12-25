package com.dimples.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.dimples.auth.po.Permission")
public class Permission implements Serializable {
    /**
    * 权限id
    */
    @ApiModelProperty(value="权限id")
    private Long permissionId;

    /**
    * 权限名称
    */
    @ApiModelProperty(value="权限名称")
    private String permissionName;

    /**
    * 菜单URL
    */
    @ApiModelProperty(value="菜单URL")
    private String permissionUrl;

    /**
    * 授权(多个用逗号分隔，如：user:list,user:create)
    */
    @ApiModelProperty(value="授权(多个用逗号分隔，如：user:list,user:create)")
    private String permission;

    /**
    * 权限类型，如button，menu
    */
    @ApiModelProperty(value="权限类型，如button，menu")
    private String permissionType;

    /**
    * 用户状态，0不启用，1启用，默认为1
    */
    @ApiModelProperty(value="用户状态，0不启用，1启用，默认为1")
    private Byte status;

    /**
    * 创建日期
    */
    @ApiModelProperty(value="创建日期")
    private Date createDate;

    /**
    * 更新日期
    */
    @ApiModelProperty(value="更新日期")
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}