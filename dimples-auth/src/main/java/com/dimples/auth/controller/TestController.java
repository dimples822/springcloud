package com.dimples.auth.controller;

import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.OpsLogTypeEnum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TestController {

    @Value("${test:lily}")
    private String test;

    @OpsLog(value = "多模块引用测试", type = OpsLogTypeEnum.TEST)
    @GetMapping("/name")
    public String test() {
        return test;
    }
}















