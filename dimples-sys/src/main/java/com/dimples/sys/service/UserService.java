package com.dimples.sys.service;

import com.dimples.sys.po.User;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/6
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     *
     * @param username String
     * @return User
     */
    User findByName(String username);
}
