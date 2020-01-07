package com.dimples.auth.service;

import com.dimples.common.dto.MenuDTO;
import com.dimples.common.dto.RoleDTO;
import com.dimples.common.dto.UserDTO;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/8
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserDTO findByUsername(String username);

    /**
     * 根据用户id查询用户角色信息
     *
     * @param userId 用户id
     * @return 角色信息
     */
    List<RoleDTO> getRoleByUserId(Long userId);


    /**
     * 根据角色id查询菜单信息
     *
     * @param roleId 角色id
     * @return 权限信息
     */
    List<MenuDTO> findPermissionByRoleId(Long roleId);
}

