package com.dimples.server.test.controller;

import com.dimples.server.test.service.SysInfoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/30
 */
@RestController
public class TestController {

    @Resource
    private SysInfoService sysInfoService;

    @GetMapping("/info")
    public String info() {
        return sysInfoService.info();
    }

}




















