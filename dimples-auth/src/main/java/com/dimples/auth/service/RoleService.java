package com.dimples.auth.service;

import com.dimples.auth.fallback.RoleServiceFallBackImpl;
import com.dimples.common.result.ResultCommon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@FeignClient(name = "dimples-sys",fallback = RoleServiceFallBackImpl.class)
public interface RoleService {

    @GetMapping("role/{userId}")
    ResultCommon getRoleByUserId(@PathVariable("userId") Integer userId);

}













