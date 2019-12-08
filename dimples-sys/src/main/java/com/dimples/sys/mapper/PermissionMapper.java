package com.dimples.sys.mapper;

import com.dimples.common.vo.PermissionVo;
import com.dimples.sys.po.Permission;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> findUserPermissions(Long id);

    List<PermissionVo> getRolePermission(Integer roleId);
}