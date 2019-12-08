package com.dimples.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo implements Serializable {
    private static final long serialVersionUID = 3881610071550902762L;

    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String name;

    private Date birthday;

    private Integer sex;

    private String email;

    private String phone;

    private Byte status;

    private Date createTime;

    private Date updateTime;

}












