package com.dimples.auth.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dimples.auth.mapper.PermissionMapper;
import com.dimples.auth.mapper.RoleMapper;
import com.dimples.auth.mapper.UserMapper;
import com.dimples.auth.service.SysUserService;
import com.dimples.common.dto.PermissionDTO;
import com.dimples.common.dto.RoleDTO;
import com.dimples.common.dto.UserDTO;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/26
 */
@Service
@DS("sys")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public List<RoleDTO> getRoleByUserId(Long userId) {
        return roleMapper.getRoleByUserId(userId);
    }

    @Override
    public List<PermissionDTO> getRolePermission(Long roleId) {
        return permissionMapper.getRolePermission(roleId);
    }
}
