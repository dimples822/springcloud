package com.dimples.sys.service;

import com.dimples.sys.po.Template;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/27
 */
public interface TemplateService {


    int deleteByPrimaryKey(Long templateId);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Long templateId);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    /**
     * 用户新增模板并绑定
     *
     * @param template Template
     * @param userId   Long
     * @param active   boolean
     * @return int
     */
    int add(Template template, Long userId, boolean active);
}


