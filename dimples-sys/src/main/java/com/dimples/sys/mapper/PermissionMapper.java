package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.common.dto.PermissionDTO;
import com.dimples.sys.po.Permission;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询用户的所有权限
     *
     * @param id Long
     * @return List<Permission>
     */
    List<Permission> findUserPermissions(Long id);

    /**
     * 根据角色id获取权限信息
     *
     * @param roleId Integer
     * @return List<PermissionDTO>
     */
    List<PermissionDTO> getRolePermission(Integer roleId);

}