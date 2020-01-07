package com.dimples.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dimples.auth.po.Menu;
import com.dimples.common.dto.MenuDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据角色id查询菜单信息
     *
     * @param roleId 角色id
     * @return List<Menu>
     */
    List<MenuDTO> findPermissionByRoleId(Long roleId);
}