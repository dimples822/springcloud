package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RolePositionMapper;
import com.dimples.sys.po.RolePosition;
import com.dimples.sys.service.RolePositionService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class RolePositionServiceImpl implements RolePositionService {

    @Resource
    private RolePositionMapper rolePositionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return rolePositionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RolePosition record) {
        return rolePositionMapper.insertSelective(record);
    }

    @Override
    public RolePosition selectByPrimaryKey(Long id) {
        return rolePositionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RolePosition record) {
        return rolePositionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RolePosition record) {
        return rolePositionMapper.updateByPrimaryKey(record);
    }

}

