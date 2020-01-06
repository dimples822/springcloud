package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.sys.po.RoleUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    /**
     * 绑定用户和角色关系
     *
     * @param userId Long
     * @param roles  String
     * @return int
     */
    int bindUserAndRoles(@Param("userId") Long userId, @Param("roles") List<String> roles);
}