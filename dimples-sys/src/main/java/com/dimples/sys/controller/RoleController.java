package com.dimples.sys.controller;

import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.eunm.OpsLogTypeEnum;
import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.RoleVo;
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
    @OpsLog(value = "新增角色", type = OpsLogTypeEnum.ADD)
    @ApiParam(name = "roleName", required = true, type = "String")
    @PostMapping("/add")
    public ResultCommon add(Role role) {
        if (role.getRoleName().isEmpty()) {
            return ResultCommon.failed(CodeAndMessageEnum.FIELD_INCOMPLETE);
        }
        int i = roleService.insertSelective(role);
        return i > 0 ? ResultCommon.success() : ResultCommon.failed();
    }

    @ApiOperation("绑定角色与权限(一个或多个)关系,以','分隔")
    @OpsLog(value = "绑定角色与权限(一个或多个)关系", type = OpsLogTypeEnum.ADD)
    @PostMapping("/bind/perm")
    public ResultCommon bindRoleAndPermission(Long role, String perms) {
        int i = permissionRoleService.bindRoleAndPermission(role, perms);
        return i > 0 ? ResultCommon.success() : ResultCommon.failed();
    }

    /**
     * 根据用户id获取角色信息
     *
     * @param userId Integer
     * @return ResultCommon<List < Role>>
     */
    @ApiOperation("根据用户id获取角色信息")
    @ApiImplicitParam(value = "用户id", paramType = "path", dataType = "int")
    @OpsLog(value = "根据用户id获取角色信息", type = OpsLogTypeEnum.SELECT)
    @GetMapping("/{userId}")
    public ResultCommon<List<RoleVo>> getRoleByUserId(@PathVariable Integer userId) {
        List<Role> roles = roleService.getRoleByUserId(userId);
        List<RoleVo> roleVos = new ArrayList<>();
        roles.forEach(role -> {
            RoleVo roleVo = Role.convert(role);
            roleVos.add(roleVo);
        });
        return new ResultCommon<List<RoleVo>>().ok(roleVos);
    }

}













