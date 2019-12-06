package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UserUGroupMapper;
import com.dimples.sys.po.UserUGroup;
import com.dimples.sys.service.UserUGroupService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserUGroupServiceImpl implements UserUGroupService {

    @Resource
    private UserUGroupMapper userUGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userUGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserUGroup record) {
        return userUGroupMapper.insertSelective(record);
    }

    @Override
    public UserUGroup selectByPrimaryKey(Long id) {
        return userUGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserUGroup record) {
        return userUGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserUGroup record) {
        return userUGroupMapper.updateByPrimaryKey(record);
    }

}

