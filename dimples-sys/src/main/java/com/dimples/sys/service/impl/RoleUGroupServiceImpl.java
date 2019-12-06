package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RoleUGroupMapper;
import com.dimples.sys.po.RoleUGroup;
import com.dimples.sys.service.RoleUGroupService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class RoleUGroupServiceImpl implements RoleUGroupService {

    @Resource
    private RoleUGroupMapper roleUGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleUGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleUGroup record) {
        return roleUGroupMapper.insertSelective(record);
    }

    @Override
    public RoleUGroup selectByPrimaryKey(Long id) {
        return roleUGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleUGroup record) {
        return roleUGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleUGroup record) {
        return roleUGroupMapper.updateByPrimaryKey(record);
    }

}

