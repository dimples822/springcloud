package com.dimples.auth.service.impl;

import com.dimples.auth.feign.SysFeignService;
import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.PermissionVo;
import com.dimples.common.vo.RoleVo;
import com.dimples.common.vo.UserVo;

import org.springframework.beans.BeanUtils;
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
    private SysFeignService sysFeignService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultCommon<UserVo> userResult = sysFeignService.findByUsername(username);
        if (userResult.getCode() != CodeAndMessageEnum.SUCCESS.getCode()) {
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
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userResult.getData(), userVo);
        ResultCommon<List<RoleVo>> roleResult = sysFeignService.getRoleByUserId(userVo.getId());
        if (roleResult.getCode() != CodeAndMessageEnum.SUCCESS.getCode()) {
            List<RoleVo> roleVoList = roleResult.getData();
            for (RoleVo role : roleVoList) {
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                ResultCommon<List<PermissionVo>> perResult = sysFeignService.getRolePermission(role.getId());
                if (perResult.getCode() != CodeAndMessageEnum.SUCCESS.getCode()) {
                    List<PermissionVo> permissionList = perResult.getData();
                    for (PermissionVo menu : permissionList) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getPermission());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }
        return new User(userVo.getUsername(), userVo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }
}
















