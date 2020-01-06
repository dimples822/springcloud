package com.dimples.sys.service.impl;

import com.dimples.common.dto.PermissionDTO;
import com.dimples.sys.mapper.PermissionMapper;
import com.dimples.sys.po.Permission;
import com.dimples.sys.service.PermissionService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findUserPermissions(Long id) {
        return permissionMapper.findUserPermissions(id);
    }

    @Override
    public List<PermissionDTO> getRolePermission(Integer roleId) {
        return permissionMapper.getRolePermission(roleId);
    }
}

