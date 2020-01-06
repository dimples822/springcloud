package com.dimples.sys.service;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2020/1/6
  */
public interface RoleUserService {

    /**
     * 绑定用户和角色关系
     *
     * @param userId  Long
     * @param roleIds String
     * @return int
     */
    int bingUserAndRole(Long userId, String roleIds);
}

