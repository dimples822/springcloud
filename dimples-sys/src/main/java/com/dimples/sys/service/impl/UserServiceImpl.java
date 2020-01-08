package com.dimples.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dimples.common.dto.UserDTO;
import com.dimples.common.transport.RequestWithPageDTO;
import com.dimples.sys.mapper.UserMapper;
import com.dimples.sys.po.RoleUser;
import com.dimples.sys.po.User;
import com.dimples.sys.service.RoleUserService;
import com.dimples.sys.service.UserService;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    private RoleUserService roleUserService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public IPage<UserDTO> findUserDetail(UserDTO user, RequestWithPageDTO request) {
        Page<UserDTO> page = new Page<>(request.getPageNum(), request.getPageSize());
        return userMapper.findUserDetailPage(page, user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createUser(UserDTO user) {
        User u = new User();
        BeanUtils.copyProperties(user, u);
        u.setStatus(Byte.valueOf(UserDTO.STATUS_VALID));
        u.setPassword(passwordEncoder.encode(UserDTO.DEFAULT_PASSWORD));
        u.setCreateDate(new Date());
        // 新增用户
        save(u);
        //保存用户角色
        if (StringUtils.isNotBlank(user.getRoleId())) {
            String[] roles = StringUtils.split(user.getRoleId());
            addUserRoles(user, roles);
        }

    }

    private void addUserRoles(UserDTO user, String[] roles) {
        List<RoleUser> roleUsers = Lists.newArrayList();
        Arrays.stream(roles).forEach(roleId -> {
            RoleUser userRole = new RoleUser();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(Long.valueOf(roleId));
            roleUsers.add(userRole);
        });
        roleUserService.saveBatch(roleUsers);
    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void deleteUsers(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        // 删除用户
        removeByIds(list);
        // 删除用户角色

    }
}
















