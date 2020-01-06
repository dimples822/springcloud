package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UserMapper;
import com.dimples.sys.po.User;
import com.dimples.sys.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

}















