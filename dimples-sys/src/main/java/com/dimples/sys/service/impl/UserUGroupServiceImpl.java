package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UserUGroupMapper;
import com.dimples.sys.service.UserUGroupService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserUGroupServiceImpl implements UserUGroupService {

    @Resource
    private UserUGroupMapper userGroupMapper;

}

