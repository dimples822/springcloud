package com.dimples.sys.po;

import java.util.Date;

import lombok.Data;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/8
  */
@Data
public class User {
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














