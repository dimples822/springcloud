package com.dimples.sys.service;

import com.dimples.sys.po.Role;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/6
 */
public interface RoleService {

    /**
     * 查询用户角色
     *
     * @param id Long
     * @return List<Role>
     */
    List<Role> findUserRole(Long id);

    /**
     * 根据用户id获取角色信息
     *
     * @param userId Integer
     * @return ResponseDTO<List < Role>>
     */
    List<Role> getRoleByUserId(Integer userId);

}
