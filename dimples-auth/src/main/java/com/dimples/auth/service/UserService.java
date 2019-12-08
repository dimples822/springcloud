package com.dimples.auth.service;

import com.dimples.auth.fallback.UserServiceFallBackImpl;
import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.UserVo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@FeignClient(name = "dimples-sys",fallback = UserServiceFallBackImpl.class)
public interface UserService {

    @GetMapping("user/{username}")
    ResultCommon<UserVo> findByUsername(@PathVariable("username") String username);

}








