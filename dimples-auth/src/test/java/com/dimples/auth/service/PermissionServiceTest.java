package com.dimples.auth.service;

import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.PermissionVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Resource
    private PermissionService permissionService;

    @Test
    public void getRolePermission() {
        ResultCommon<List<PermissionVo>> rolePermission = permissionService.getRolePermission(1);
        List<PermissionVo> data = rolePermission.getData();
        for (PermissionVo datum : data) {
            log.info(String.valueOf(datum));
        }
    }
}