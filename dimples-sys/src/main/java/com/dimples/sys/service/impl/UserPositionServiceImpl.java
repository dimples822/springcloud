package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UserPositionMapper;
import com.dimples.sys.po.UserPosition;
import com.dimples.sys.service.UserPositionService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class UserPositionServiceImpl implements UserPositionService {

    @Resource
    private UserPositionMapper userPositionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userPositionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserPosition record) {
        return userPositionMapper.insertSelective(record);
    }

    @Override
    public UserPosition selectByPrimaryKey(Long id) {
        return userPositionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPosition record) {
        return userPositionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserPosition record) {
        return userPositionMapper.updateByPrimaryKey(record);
    }

}

