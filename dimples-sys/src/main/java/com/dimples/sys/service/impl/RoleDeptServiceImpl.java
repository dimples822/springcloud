package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RoleDeptMapper;
import com.dimples.sys.po.RoleDept;
import com.dimples.sys.service.RoleDeptService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class RoleDeptServiceImpl implements RoleDeptService {

    @Resource
    private RoleDeptMapper roleDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleDept record) {
        return roleDeptMapper.insertSelective(record);
    }

    @Override
    public RoleDept selectByPrimaryKey(Long id) {
        return roleDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleDept record) {
        return roleDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleDept record) {
        return roleDeptMapper.updateByPrimaryKey(record);
    }

}

