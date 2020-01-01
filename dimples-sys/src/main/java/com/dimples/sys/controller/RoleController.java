package com.dimples.sys.controller;

import com.dimples.common.dto.RoleDTO;
import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.transport.ResponseDTO;
import com.dimples.sys.po.Role;
import com.dimples.sys.service.PermissionRoleService;
import com.dimples.sys.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 角色关联模块
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
@Slf4j
@Api(tags = "角色关联模块")
@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;
    private PermissionRoleService permissionRoleService;

    @Autowired
    public RoleController(RoleService roleService, PermissionRoleService permissionRoleService) {
        this.roleService = roleService;
        this.permissionRoleService = permissionRoleService;
    }

    @ApiOperation("新增角色")
    @ApiParam(name = "roleName", required = true, type = "String")
    @PostMapping("/add")
    public ResponseDTO add(Role role) {
        if (role.getRoleName().isEmpty()) {
            return ResponseDTO.failed(CodeAndMessageEnum.FIELD_INCOMPLETE);
        }
        int i = roleService.insertSelective(role);
        return i > 0 ? ResponseDTO.success() : ResponseDTO.failed();
    }

    @ApiOperation("绑定角色与权限(一个或多个)关系,以','分隔")
    @PostMapping("/bind/perm")
    public ResponseDTO bindRoleAndPermission(Long role, String perms) {
        int i = permissionRoleService.bindRoleAndPermission(role, perms);
        return i > 0 ? ResponseDTO.success() : ResponseDTO.failed();
    }

    /**
     * 根据用户id获取角色信息
     *
     * @param userId Integer
     * @return ResponseDTO<List < Role>>
     */
    @ApiOperation("根据用户id获取角色信息")
    @ApiImplicitParam(value = "用户id", paramType = "path", dataType = "int")
    @GetMapping("/{userId}")
    public ResponseDTO<List<RoleDTO>> getRoleByUserId(@PathVariable Integer userId) {
        List<Role> roles = roleService.getRoleByUserId(userId);
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roles.forEach(role -> {
            RoleDTO roleDTO = Role.convert(role);
            roleDTOS.add(roleDTO);
        });
        return new ResponseDTO<List<RoleDTO>>().ok(roleDTOS);
    }

}













