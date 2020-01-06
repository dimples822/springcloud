package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.sys.po.Role;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询用户角色
     *
     * @param id Long
     * @return List<Role>
     */
    List<Role> findUserRole(Long id);

    /**
     * 根据用户id获取角色信息
     *
     * @param userId Integer
     * @return ResponseDTO<List < Role>>
     */
    List<Role> getRoleByUserId(Integer userId);
}