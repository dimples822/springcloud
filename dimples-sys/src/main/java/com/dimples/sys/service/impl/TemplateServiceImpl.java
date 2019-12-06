package com.dimples.sys.service.impl;

import com.dimples.common.exception.BizException;
import com.dimples.sys.mapper.TemplateMapper;
import com.dimples.sys.mapper.TemplateUserMapper;
import com.dimples.sys.po.Template;
import com.dimples.sys.po.TemplateUser;
import com.dimples.sys.service.TemplateService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/27
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;
    @Resource
    private TemplateUserMapper templateUserMapper;

    @Override
    public int deleteByPrimaryKey(Long templateId) {
        return templateMapper.deleteByPrimaryKey(templateId);
    }

    @Override
    public int insertSelective(Template record) {
        if (record.getCreateUserId() == null) {
            throw new BizException("插入模板时创建人Id不能为空");
        }
        if (record.getTemplateType() == null) {
            throw new BizException("插入模板时模板类型不能为空");
        }
        record.setCreateTime(new Date());
        return templateMapper.insertSelective(record);
    }

    @Override
    public Template selectByPrimaryKey(Long templateId) {
        return templateMapper.selectByPrimaryKey(templateId);
    }

    @Override
    public int updateByPrimaryKeySelective(Template record) {
        return templateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Template record) {
        return templateMapper.updateByPrimaryKey(record);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(Template template, Long userId, boolean active) {
        int result;
        TemplateUser templateUser;
        if (template.getTemplateId() == null) {
            // 先插入模板
            if (template.getCreateUserId() == null) {
                template.setCreateUserId(userId);
            }
            insertSelective(template);
            // 插入关联关系
            templateUser = new TemplateUser();
            templateUser.setTemplateId(template.getTemplateId());
            templateUser.setUserId(userId);
            result = templateUserMapper.insertSelective(templateUser);
            // 设置模板
            if (active) {
                // 先重置用户当前类型的默认模板
                clearBindTemplate(template, userId);
                // 激活当前新增的模板
                activeCurrentTemplate(template.getTemplateId(), userId);
            }
        } else {
            // 此时为用户更新模板，先根据模板id去获取模板信息，然后与新模板比对
            Template templateById = templateMapper.selectByPrimaryKey(template.getTemplateId());
            if (templateById == null) {
                throw new BizException("未找到与当前模板匹配的数据");
            }
            // 比对信息
            if (templateById.getTemplateContent().equals(template.getTemplateContent())) {
                throw new BizException("当前模板未做任何修改，更新失败");
            } else {
                // 新增到模板表
                result = insertSelective(template);
                // 设置模板
                if (active) {
                    // 先重置用户当前类型的默认模板
                    clearBindTemplate(template, userId);
                    // 激活当前新增的模板
                    activeCurrentTemplate(template.getTemplateId(), userId);
                }
            }
        }
        return result;
    }

    private void activeCurrentTemplate(Long templateId, Long userId) {
        templateUserMapper.activeCurrentTemplate(templateId, userId);
    }

    private void clearBindTemplate(Template template, Long userId) {
        templateUserMapper.clearBindTemplate(template, userId);
    }
}














