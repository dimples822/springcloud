package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-RoleDept")
@Data
@TableName(value = "db_base_permission.tb_role_dept")
public class RoleDept implements Serializable {
    /**
     * 角色科室关联id
     */
    @TableId(value = "role_dept_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色科室关联id")
    private Long roleDeptId;

    /**
     * 科室id
     */
    @TableField(value = "dept_id")
    @ApiModelProperty(value = "科室id")
    private Long deptId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}