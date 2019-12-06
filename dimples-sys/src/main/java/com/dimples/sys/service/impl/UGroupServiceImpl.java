package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.UGroupMapper;
import com.dimples.sys.po.UGroup;
import com.dimples.sys.service.UGroupService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class UGroupServiceImpl implements UGroupService {

    @Resource
    private UGroupMapper uGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return uGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UGroup record) {
        return uGroupMapper.insertSelective(record);
    }

    @Override
    public UGroup selectByPrimaryKey(Long id) {
        return uGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UGroup record) {
        return uGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UGroup record) {
        return uGroupMapper.updateByPrimaryKey(record);
    }

}

