package com.dimples.sys.mapper;

import com.dimples.sys.po.RoleUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleUserMapper {
    int deleteByPrimaryKey(Long roleUserId);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Long roleUserId);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);

    int bindUserAndRoles(@Param("userId") Long userId, @Param("roles") List<String> roles);
}