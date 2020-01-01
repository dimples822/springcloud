package com.dimples.sys.controller;

import com.dimples.common.dto.PermissionDTO;
import com.dimples.common.transport.ResponseDTO;
import com.dimples.sys.po.Permission;
import com.dimples.sys.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 权限模块
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
@Slf4j
@Api(tags = "权限管理模块")
@RestController
@RequestMapping("/perms")
public class PermissionController {

    private PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @ApiOperation("新增权限")
    @PostMapping("/add")
    public ResponseDTO add(Permission permission) {
        int i = permissionService.insertSelective(permission);
        return i > 0 ? ResponseDTO.success() : ResponseDTO.failed();
    }

    @ApiOperation("根据角色id获取权限信息")
    @ApiImplicitParam(value = "角色id", paramType = "path", dataType = "int")
    @GetMapping("/{roleId}")
    public ResponseDTO<List<PermissionDTO>> getRolePermission(@PathVariable Integer roleId) {
        List<PermissionDTO> permissionDTOS = permissionService.getRolePermission(roleId);
        return new ResponseDTO<List<PermissionDTO>>().ok(permissionDTOS);
    }
}


















