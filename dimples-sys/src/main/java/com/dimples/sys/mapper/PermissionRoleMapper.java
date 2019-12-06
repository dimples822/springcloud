package com.dimples.sys.mapper;

import com.dimples.sys.po.PermissionRole;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface PermissionRoleMapper {
    int deleteByPrimaryKey(Long permissionRoleId);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Long permissionRoleId);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);

    int bindRoleAndPermission(@Param("role") Long role, @Param("list") List<String> list);
}