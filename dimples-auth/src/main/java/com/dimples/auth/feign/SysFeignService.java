package com.dimples.auth.feign;

import com.dimples.auth.feign.fallback.SysFeignServiceFallBackImpl;
import com.dimples.common.result.R;
import com.dimples.common.vo.PermissionVo;
import com.dimples.common.vo.RoleVo;
import com.dimples.common.vo.UserVo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/8
 */
@FeignClient(name = "dimples-sys", fallback = SysFeignServiceFallBackImpl.class)
public interface SysFeignService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("user/{username}")
    R<UserVo> findByUsername(@PathVariable("username") String username);

    /**
     * 根据用户id查询用户角色信息
     *
     * @param userId 用户id
     * @return 角色信息
     */
    @GetMapping("role/{userId}")
    R<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Long userId);

    /**
     * 根据角色id查询权限信息
     *
     * @param roleId 角色id
     * @return 权限信息
     */
    @GetMapping("perms/{roleId}")
    R<List<PermissionVo>> getRolePermission(@PathVariable("roleId") Long roleId);

}

