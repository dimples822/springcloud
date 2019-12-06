package com.dimples.sys.service;

import com.dimples.sys.po.User;

public interface UserService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找用户
     *
     * @param username String
     * @return User
     */
    User findByName(String username);
}
