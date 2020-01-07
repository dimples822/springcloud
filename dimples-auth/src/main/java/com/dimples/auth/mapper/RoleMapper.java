package com.dimples.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.auth.po.Role;
import com.dimples.common.dto.RoleDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id去角色信息
     *
     * @param userId Long
     * @return List<RoleDTO>
     */
    List<RoleDTO> getRoleByUserId(Long userId);
}