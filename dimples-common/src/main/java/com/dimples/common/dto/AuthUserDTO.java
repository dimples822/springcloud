package com.dimples.common.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthUserDTO extends User {

    private static final long serialVersionUID = -6411066541689297219L;

    private Long userId;

    private String username;

    private String name;

    private Date birthday;

    private Integer sex;

    private String email;

    private String phone;

    private Byte status;

    private String createDate;

    private String modifyDate;


    public AuthUserDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AuthUserDTO(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


}
