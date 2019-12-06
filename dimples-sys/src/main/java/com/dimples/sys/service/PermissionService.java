package com.dimples.sys.service;

import com.dimples.sys.po.Permission;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
public interface PermissionService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 查询用户的所有权限
     *
     * @param id Long
     * @return List<Permission>
     */
    List<Permission> findUserPermissions(Long id);
}

