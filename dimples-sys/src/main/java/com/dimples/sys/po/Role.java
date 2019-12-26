package com.dimples.sys.po;

import com.dimples.common.dto.RoleDTO;

import java.util.Date;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/8
 */
@Data
public class Role {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;

    public static RoleDTO convert(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(role.roleId);
        roleDTO.setRoleName(role.getRoleName());
        roleDTO.setCreateTime(role.getCreateDate());
        roleDTO.setUpdateTime(role.getModifyDate());
        return roleDTO;
    }
}
















