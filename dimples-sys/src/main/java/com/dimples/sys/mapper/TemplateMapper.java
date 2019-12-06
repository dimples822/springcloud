package com.dimples.sys.mapper;

import com.dimples.sys.po.Template;

import org.apache.ibatis.annotations.Mapper;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Mapper
public interface TemplateMapper {
    int deleteByPrimaryKey(Long templateId);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Long templateId);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
}