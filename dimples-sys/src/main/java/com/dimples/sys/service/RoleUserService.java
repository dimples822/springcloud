package com.dimples.sys.service;

import com.dimples.sys.po.RoleUser;

public interface RoleUserService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);

    /**
     * 绑定用户和角色关系
     *
     * @param userId  Long
     * @param roleIds String
     * @return int
     */
    int bingUserAndRole(Long userId, String roleIds);
}

