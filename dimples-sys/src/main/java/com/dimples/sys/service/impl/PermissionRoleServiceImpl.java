package com.dimples.sys.service.impl;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.utils.SysConstant;
import com.dimples.sys.mapper.PermissionRoleMapper;
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













