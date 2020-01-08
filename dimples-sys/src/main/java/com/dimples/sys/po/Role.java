package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;import com.dimples.common.dto.RoleDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-Role")
@Data
@TableName(value = "db_base_permission.tb_role")
public class Role implements Serializable {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    /**
     * 更新日期
     */
    @TableField(value = "modify_date")
    @ApiModelProperty(value = "更新日期")
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public static RoleDTO convert(com.dimples.sys.po.Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(role.roleId);
        roleDTO.setRoleName(role.getRoleName());
        roleDTO.setCreateTime(role.getCreateDate());
        roleDTO.setUpdateTime(role.getModifyDate());
        return roleDTO;
    }
}