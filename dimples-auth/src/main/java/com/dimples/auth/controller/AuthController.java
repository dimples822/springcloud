package com.dimples.auth.controller;

import com.dimples.common.exception.BizException;
import com.dimples.common.result.R;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/14
 */
@RestController
@Slf4j
public class AuthController {

    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    public AuthController(ConsumerTokenServices consumerTokenServices) {
        this.consumerTokenServices = consumerTokenServices;
    }

    @GetMapping("/oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("/user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("/logout")
    public R logout(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        if (!consumerTokenServices.revokeToken(token)) {
            throw new BizException("退出登录失败");
        }
        return R.error("退出登录成功");
    }
}















