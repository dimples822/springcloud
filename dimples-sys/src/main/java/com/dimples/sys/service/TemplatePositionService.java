package com.dimples.sys.service;

import com.dimples.sys.po.TemplatePosition;
public interface TemplatePositionService{


    int deleteByPrimaryKey(Long templatePositionId);

    int insertSelective(TemplatePosition record);

    TemplatePosition selectByPrimaryKey(Long templatePositionId);

    int updateByPrimaryKeySelective(TemplatePosition record);

    int updateByPrimaryKey(TemplatePosition record);

}
