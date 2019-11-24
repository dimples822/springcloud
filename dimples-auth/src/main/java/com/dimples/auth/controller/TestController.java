package com.dimples.auth.controller;

import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.OpsLogTypeEnum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @Value("${dimples:test:Nacos配置中心测试}")
    private String test;

    @OpsLog(value = "多模块引用测试", type = OpsLogTypeEnum.TEST)
    @GetMapping("/{name}")
    public Map<String, Object> testZuul(@PathVariable String name) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", name);
        map.put("nacos-test", test);
        log.info(test);
        return map;
    }
}















