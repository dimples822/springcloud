package com.dimples.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dimples.sys.po.RoleUser;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/6
 */
public interface RoleUserService extends IService<RoleUser> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);

}


