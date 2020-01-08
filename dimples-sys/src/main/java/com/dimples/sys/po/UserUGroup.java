package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-UserUGroup")
@Data
@TableName(value = "db_base_permission.tb_user_u_group")
public class UserUGroup implements Serializable {
    /**
     * 用户与用户组关联id
     */
    @TableId(value = "user_u_group_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户与用户组关联id")
    private Long userUGroupId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户组id
     */
    @TableField(value = "u_group_id")
    @ApiModelProperty(value = "用户组id")
    private Long uGroupId;

    private static final long serialVersionUID = 1L;
}