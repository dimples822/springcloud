package com.dimples.auth.mapper;

import com.dimples.auth.po.Permission;
import com.dimples.common.dto.PermissionDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<PermissionDTO> getRolePermission(Long roleId);
}