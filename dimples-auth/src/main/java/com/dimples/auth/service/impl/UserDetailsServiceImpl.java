package com.dimples.auth.service.impl;

import com.dimples.auth.service.SysUserService;
import com.dimples.common.dto.MenuDTO;
import com.dimples.common.dto.RoleDTO;
import com.dimples.common.dto.UserDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

/**
 * 用户的详细信息获取 用户基础信息、角色、权限
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userResult = sysUserService.findByUsername(username);
        if (userResult == null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // 可用性 :true:可用 false:不可用
        final boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        final boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        final boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        final boolean accountNonLocked = true;
        List<RoleDTO> roleResult = sysUserService.getRoleByUserId(userResult.getUserId());
        if (!roleResult.isEmpty()) {
            for (RoleDTO role : roleResult) {
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                List<MenuDTO> permissionByRoleId = sysUserService.findPermissionByRoleId(role.getRoleId());
                if (!permissionByRoleId.isEmpty()) {
                    for (MenuDTO menu : permissionByRoleId) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getPerms());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }
        return new User(userResult.getUsername(), userResult.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }
}
















