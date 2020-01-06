package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.sys.po.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户
     *
     * @param username String
     * @return User
     */
    User findByName(String username);
}