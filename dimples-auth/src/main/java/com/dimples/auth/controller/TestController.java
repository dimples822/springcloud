package com.dimples.auth.controller;

import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.OpsLogTypeEnum;

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
public class TestController {

    @OpsLog(value = "多模块引用测试", type = OpsLogTypeEnum.TEST)
    @GetMapping("/client/{name}")
    public Map<String, Object> testZuul(@PathVariable String name) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", name);
        return map;
    }
}















