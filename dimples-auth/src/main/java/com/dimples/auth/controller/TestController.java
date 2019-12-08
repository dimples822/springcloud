package com.dimples.auth.controller;

import com.dimples.auth.service.impl.UserDetailsServiceImpl;
import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.OpsLogTypeEnum;
import com.dimples.common.result.ResultCommon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/14
 */
@RestController
@Slf4j
@RefreshScope
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Value("${test:lily}")
    private String test;

    @OpsLog(value = "多模块引用测试", type = OpsLogTypeEnum.TEST)
    @GetMapping("/name")
    public String test() {
        return test;
    }

    @GetMapping("/auth/user")
    public ResultCommon<UserDetails> getAuth() {
        UserDetails admin = userDetailsService.loadUserByUsername("admin");
        return new ResultCommon<UserDetails>().ok(admin);
    }
}















