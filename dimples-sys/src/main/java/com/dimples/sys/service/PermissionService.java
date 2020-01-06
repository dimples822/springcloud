package com.dimples.sys.service;

import com.dimples.common.dto.PermissionDTO;
import com.dimples.sys.po.Permission;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
public interface PermissionService {

    /**
     * 查询用户的所有权限
     *
     * @param id Long
     * @return List<Permission>
     */
    List<Permission> findUserPermissions(Long id);

    /**
     * 根据角色id获取权限信息
     *
     * @param roleId Integer
     * @return List<PermissionDTO>
     */
    List<PermissionDTO> getRolePermission(Integer roleId);

}

