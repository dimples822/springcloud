package com.dimples.sys.po;

import com.dimples.common.vo.RoleVo;

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

    public static RoleVo convert(Role role) {
        RoleVo roleVo = new RoleVo();
        roleVo.setRoleId(role.roleId);
        roleVo.setRoleName(role.getRoleName());
        roleVo.setCreateTime(role.getCreateDate());
        roleVo.setUpdateTime(role.getModifyDate());
        return roleVo;
    }
}
















