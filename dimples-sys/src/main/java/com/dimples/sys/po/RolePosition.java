package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-RolePosition")
@Data
@TableName(value = "db_base_permission.tb_role_position")
public class RolePosition implements Serializable {
    /**
     * 用户角色关联id
     */
    @TableId(value = "role_position_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户角色关联id")
    private Long rolePositionId;

    /**
     * 职位id
     */
    @TableField(value = "position_id")
    @ApiModelProperty(value = "职位id")
    private Long positionId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}