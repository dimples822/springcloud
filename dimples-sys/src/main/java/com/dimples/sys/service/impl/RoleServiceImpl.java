package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RoleMapper;
import com.dimples.sys.po.Role;
import com.dimples.sys.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findUserRole(Long id) {
        return roleMapper.findUserRole(id);
    }

    @Override
    public List<Role> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }

}

