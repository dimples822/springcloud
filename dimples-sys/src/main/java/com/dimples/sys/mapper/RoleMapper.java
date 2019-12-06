package com.dimples.sys.mapper;

import com.dimples.sys.po.Role;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findUserRole(Long id);
}