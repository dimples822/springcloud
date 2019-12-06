package com.dimples.sys.service.impl;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.utils.SysConstant;
import com.dimples.sys.mapper.PermissionRoleMapper;
import com.dimples.sys.po.PermissionRole;
import com.dimples.sys.service.PermissionRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/15
 */
@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Resource
    private PermissionRoleMapper permissionRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PermissionRole record) {
        return permissionRoleMapper.insertSelective(record);
    }

    @Override
    public PermissionRole selectByPrimaryKey(Long id) {
        return permissionRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PermissionRole record) {
        return permissionRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PermissionRole record) {
        return permissionRoleMapper.updateByPrimaryKey(record);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bindRoleAndPermission(Long role, String perms) {
        String[] perm = perms.split(SysConstant.PRAMS_SEPARATOR);
        if (perm.length == 0 || role == null) {
            throw new BizException(CodeAndMessageEnum.REQUEST_INVALIDATE);
        }
        List<String> list = Arrays.asList(perm);
        return permissionRoleMapper.bindRoleAndPermission(role, list);
    }

}













