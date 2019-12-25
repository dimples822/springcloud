package com.dimples.auth.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/25
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

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

    private static final long serialVersionUID = 1L;

}