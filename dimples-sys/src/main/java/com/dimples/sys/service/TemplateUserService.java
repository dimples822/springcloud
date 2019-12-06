package com.dimples.sys.service;

import com.dimples.sys.po.TemplateUser;

public interface TemplateUserService {


    int deleteByPrimaryKey(Long templateUserId);

    int insertSelective(TemplateUser record);

    TemplateUser selectByPrimaryKey(Long templateUserId);

    int updateByPrimaryKeySelective(TemplateUser record);

    int updateByPrimaryKey(TemplateUser record);

    /**
     * 绑定用户与模板
     *
     * @param templateId Long
     * @param userId     Long
     * @return int
     */
    int bind(Long templateId, Long userId);
}


















