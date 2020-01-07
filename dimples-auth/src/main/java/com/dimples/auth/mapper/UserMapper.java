package com.dimples.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.auth.po.User;
import com.dimples.common.dto.UserDTO;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名取用户登录信息
     *
     * @param username String
     * @return UserDTO
     */
    UserDTO findByName(String username);
}