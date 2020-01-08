package com.dimples.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dimples.common.dto.UserDTO;
import com.dimples.common.transport.RequestWithPageDTO;
import com.dimples.sys.mapper.UserMapper;
import com.dimples.sys.po.User;
import com.dimples.sys.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public IPage<User> findUserDetail(UserDTO user, RequestWithPageDTO request) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        return userMapper.findUserDetailPage(page, user);
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUsers(String[] userIds) {

    }
}















