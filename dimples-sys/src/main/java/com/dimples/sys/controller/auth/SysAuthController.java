package com.dimples.sys.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
@RestController
public class SysAuthController {

    @GetMapping("/info")
    public String info(){
        return "dimples-sys";
    }

    @GetMapping("/user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("/test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1(){
        return "拥有'user:add'权限";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2(){
        return "拥有'user:update'权限";
    }

}
