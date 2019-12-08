package com.dimples.auth.service;

import com.dimples.auth.fallback.PermissionServiceFallBackImpl;
import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.PermissionVo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@FeignClient(name = "dimples-sys",fallback = PermissionServiceFallBackImpl.class)
public interface PermissionService {

    @GetMapping("perms/{roleId}")
    ResultCommon<List<PermissionVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}














