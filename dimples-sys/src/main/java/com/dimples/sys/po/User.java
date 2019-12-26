package com.dimples.sys.po;

import com.dimples.common.dto.UserDTO;

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

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
        userDTO.setCreateTime(user.getCreateDate());
        userDTO.setUpdateTime(user.getModifyDate());
        return userDTO;
    }
}














