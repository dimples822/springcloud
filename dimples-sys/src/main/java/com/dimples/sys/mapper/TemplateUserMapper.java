package com.dimples.sys.mapper;

import com.dimples.sys.po.Template;
import com.dimples.sys.po.TemplateUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/28
 */
@Mapper
public interface TemplateUserMapper {
    int deleteByPrimaryKey(Long templateUserId);

    int insertSelective(TemplateUser record);

    TemplateUser selectByPrimaryKey(Long templateUserId);

    int updateByPrimaryKeySelective(TemplateUser record);

    int updateByPrimaryKey(TemplateUser record);

    /**
     * 重置用户当前类型的默认模板
     *
     * @param template Template
     * @param userId   Long
     */
    void clearBindTemplate(@Param("template") Template template, @Param("userId") Long userId);

    /**
     * 激活当前新增的模板
     *
     * @param templateId Long
     * @param userId     Long
     */
    void activeCurrentTemplate(@Param("template") Long templateId, @Param("userId") Long userId);
}










