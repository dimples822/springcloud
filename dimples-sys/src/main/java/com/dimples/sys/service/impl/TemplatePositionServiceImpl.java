package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.TemplatePositionMapper;
import com.dimples.sys.po.TemplatePosition;
import com.dimples.sys.service.TemplatePositionService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class TemplatePositionServiceImpl implements TemplatePositionService {

    @Resource
    private TemplatePositionMapper templatePositionMapper;

    @Override
    public int deleteByPrimaryKey(Long templatePositionId) {
        return templatePositionMapper.deleteByPrimaryKey(templatePositionId);
    }

    @Override
    public int insertSelective(TemplatePosition record) {
        return templatePositionMapper.insertSelective(record);
    }

    @Override
    public TemplatePosition selectByPrimaryKey(Long templatePositionId) {
        return templatePositionMapper.selectByPrimaryKey(templatePositionId);
    }

    @Override
    public int updateByPrimaryKeySelective(TemplatePosition record) {
        return templatePositionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TemplatePosition record) {
        return templatePositionMapper.updateByPrimaryKey(record);
    }

}
