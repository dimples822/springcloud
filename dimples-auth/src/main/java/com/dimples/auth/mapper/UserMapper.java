package com.dimples.auth.mapper;

import com.dimples.auth.po.User;
import com.dimples.common.dto.UserDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserDTO findByName(String username);
}