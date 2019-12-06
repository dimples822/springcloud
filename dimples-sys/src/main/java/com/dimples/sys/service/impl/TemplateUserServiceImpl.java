package com.dimples.sys.service.impl;

import com.dimples.common.exception.BizException;
import com.dimples.sys.mapper.TemplateUserMapper;
import com.dimples.sys.po.TemplateUser;
import com.dimples.sys.service.TemplateUserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class TemplateUserServiceImpl implements TemplateUserService {

    @Resource
    private TemplateUserMapper templateUserMapper;

    @Override
    public int deleteByPrimaryKey(Long templateUserId) {
        return templateUserMapper.deleteByPrimaryKey(templateUserId);
    }

    @Override
    public int insertSelective(TemplateUser record) {
        return templateUserMapper.insertSelective(record);
    }

    @Override
    public TemplateUser selectByPrimaryKey(Long templateUserId) {
        return templateUserMapper.selectByPrimaryKey(templateUserId);
    }

    @Override
    public int updateByPrimaryKeySelective(TemplateUser record) {
        return templateUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TemplateUser record) {
        return templateUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int bind(Long templateId, Long userId) {
        if (templateId == null || userId == null) {
            throw new BizException("绑定用户与模板失败,模板Id或用户Id不全");
        }
        TemplateUser templateUser = new TemplateUser();
        templateUser.setTemplateId(templateId);
        templateUser.setUserId(userId);
        return templateUserMapper.insertSelective(templateUser);
    }
}
















