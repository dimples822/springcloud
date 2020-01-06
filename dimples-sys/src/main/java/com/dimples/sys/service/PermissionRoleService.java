package com.dimples.sys.service;

public interface PermissionRoleService {

    /**
     * 绑定角色与权限(一个或多个)关系
     *
     * @param role  Long
     * @param perms String
     * @return int
     */
    int bindRoleAndPermission(Long role, String perms);
}

