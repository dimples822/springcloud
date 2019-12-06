package com.dimples.sys.mapper;

import com.dimples.sys.po.TemplatePosition;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface TemplatePositionMapper {
    int deleteByPrimaryKey(Long templatePositionId);

    int insertSelective(TemplatePosition record);

    TemplatePosition selectByPrimaryKey(Long templatePositionId);

    int updateByPrimaryKeySelective(TemplatePosition record);

    int updateByPrimaryKey(TemplatePosition record);
}