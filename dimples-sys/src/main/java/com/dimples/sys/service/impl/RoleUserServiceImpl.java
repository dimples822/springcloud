package com.dimples.sys.service.impl;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.utils.SysConstant;
import com.dimples.sys.mapper.RoleUserMapper;
import com.dimples.sys.po.RoleUser;
import com.dimples.sys.service.RoleUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Resource
    private RoleUserMapper roleUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleUser record) {
        return roleUserMapper.insertSelective(record);
    }

    @Override
    public RoleUser selectByPrimaryKey(Long id) {
        return roleUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleUser record) {
        return roleUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleUser record) {
        return roleUserMapper.updateByPrimaryKey(record);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bingUserAndRole(Long userId, String roleIds) {
        String[] params = roleIds.split(SysConstant.PRAMS_SEPARATOR);
        if (params.length == 0 || userId == null) {
            throw new BizException(CodeAndMessageEnum.REQUEST_INVALIDATE);
        }
        List<String> roles = Arrays.asList(params);
        return roleUserMapper.bindUserAndRoles(userId, roles);
    }
}















