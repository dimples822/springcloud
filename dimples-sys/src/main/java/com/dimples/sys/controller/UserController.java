package com.dimples.sys.controller;

import com.dimples.common.annotation.OpsLog;
import com.dimples.common.eunm.OpsLogTypeEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.result.ResultCommon;
import com.dimples.sys.po.User;
import com.dimples.sys.service.RoleUserService;
import com.dimples.sys.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户管理模块接口
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/14
 */
@Slf4j
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private RoleUserService roleUserService;

    @Autowired
    public UserController(UserService userService, RoleUserService roleUserService) {
        this.userService = userService;
        this.roleUserService = roleUserService;
    }

    @ApiOperation("添加用户")
    @OpsLog(value = "添加用户", type = OpsLogTypeEnum.ADD)
    @PostMapping("/add")
    public ResultCommon add(User user) {
        try {
            userService.insertSelective(user);
        } catch (Exception e) {
            throw new BizException(e.getMessage());
        }
        return ResultCommon.success();
    }

    @ApiOperation("绑定用户和角色(一个或多个)之间的关系,用','分隔")
    @OpsLog(value = "绑定用户和角色(一个或多个)之间的关系", type = OpsLogTypeEnum.ADD)
    @PostMapping("/bind/role")
    public ResultCommon bindUserAndRole(Long userId, String roleIds) {
        int i = roleUserService.bingUserAndRole(userId, roleIds);
        return i > 0 ? ResultCommon.success() : ResultCommon.failed();
    }

    @ApiOperation("根据用户名查询用户")
    @ApiImplicitParam(value = "用户名", paramType = "path", dataType = "int")
    @OpsLog(value = "根据用户名查询用户", type = OpsLogTypeEnum.SELECT)
    @GetMapping("/{username}")
    public ResultCommon<User> findByUsername(@PathVariable String username) {
        User users = userService.findByName(username);
        return new ResultCommon<User>().ok(users);
    }
}































