package com.dimples.auth.mapper;

import com.dimples.auth.po.Role;
import com.dimples.common.dto.RoleDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleDTO> getRoleByUserId(Long userId);
}