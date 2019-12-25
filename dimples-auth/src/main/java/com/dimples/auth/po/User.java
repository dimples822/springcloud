package com.dimples.auth.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com.dimples.auth.po.User")
public class User implements Serializable {
    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 登录密码
    */
    @ApiModelProperty(value="登录密码")
    private String password;

    /**
    * 盐
    */
    @ApiModelProperty(value="盐")
    private String salt;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
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