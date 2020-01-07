package com.dimples.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.auth.po.Permission;
import com.dimples.common.dto.PermissionDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据角色id去权限信息
     *
     * @param roleId Long
     * @return List<PermissionDTO>
     */
    List<PermissionDTO> getRolePermission(Long roleId);
}