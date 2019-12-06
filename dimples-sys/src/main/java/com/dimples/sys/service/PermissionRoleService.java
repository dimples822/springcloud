package com.dimples.sys.service;

import com.dimples.sys.po.PermissionRole;

public interface PermissionRoleService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);

    /**
     * 绑定角色与权限(一个或多个)关系
     *
     * @param role  Long
     * @param perms String
     * @return int
     */
    int bindRoleAndPermission(Long role, String perms);
}

