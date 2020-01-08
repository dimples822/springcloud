package com.dimples.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dimples.common.dto.UserDTO;
import com.dimples.common.exception.BizException;
import com.dimples.common.transport.RequestWithPageDTO;
import com.dimples.common.transport.ResponseDTO;
import com.dimples.sys.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public ResponseDTO userList(RequestWithPageDTO queryRequest, UserDTO user) {
        IPage<UserDTO> userDetail = userService.findUserDetail(user, queryRequest);
        return ResponseDTO.success(userDetail);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid UserDTO user) throws BizException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new BizException(message);
        }
    }


}
















