package com.dimples.auth.feign;

import com.dimples.auth.fallback.SysFeignServiceFallBackImpl;
import com.dimples.common.result.ResultCommon;
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
@FeignClient(name = "dimples-sys",fallback = SysFeignServiceFallBackImpl.class)
public interface SysFeignService {

    @GetMapping("user/{username}")
    ResultCommon<UserVo> findByUsername(@PathVariable("username") String username);

    @GetMapping("role/{userId}")
    ResultCommon<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);

    @GetMapping("perms/{roleId}")
    ResultCommon<List<PermissionVo>> getRolePermission(@PathVariable("roleId") Integer roleId);

}

