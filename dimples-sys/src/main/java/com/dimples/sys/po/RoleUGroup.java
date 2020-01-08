package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-RoleUGroup")
@Data
@TableName(value = "db_base_permission.tb_role_u_group")
public class RoleUGroup implements Serializable {
    /**
     * 角色用户组关联id
     */
    @TableId(value = "role_u_group_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色用户组关联id")
    private Long roleUGroupId;

    /**
     * 用户组id
     */
    @TableField(value = "u_group_id")
    @ApiModelProperty(value = "用户组id")
    private Long uGroupId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}