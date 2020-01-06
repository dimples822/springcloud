package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.sys.po.PermissionRole;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface PermissionRoleMapper extends BaseMapper<PermissionRole> {

    /**
     * 绑定角色与权限(一个或多个)关系
     *
     * @param role Long
     * @param list list
     * @return int
     */
    int bindRoleAndPermission(@Param("role") Long role, @Param("list") List<String> list);
}