package com.dimples.sys.service;

import com.dimples.sys.po.Role;

import java.util.List;

public interface RoleService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

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
     * @return ResultCommon<List < Role>>
     */
    List<Role> getRoleByUserId(Integer userId);

}
