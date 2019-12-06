package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UserDeptMapper;
import com.dimples.sys.po.UserDept;
import com.dimples.sys.service.UserDeptService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class UserDeptServiceImpl implements UserDeptService {

    @Resource
    private UserDeptMapper userDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserDept record) {
        return userDeptMapper.insertSelective(record);
    }

    @Override
    public UserDept selectByPrimaryKey(Long id) {
        return userDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDept record) {
        return userDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserDept record) {
        return userDeptMapper.updateByPrimaryKey(record);
    }

}

