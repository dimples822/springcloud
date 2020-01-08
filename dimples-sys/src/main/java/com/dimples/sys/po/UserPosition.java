package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-UserPosition")
@Data
@TableName(value = "db_base_permission.tb_user_position")
public class UserPosition implements Serializable {
    /**
     * 用户职位关联id
     */
    @TableId(value = "user_position_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户职位关联id")
    private Long userPositionId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 职位id
     */
    @TableField(value = "position_id")
    @ApiModelProperty(value = "职位id")
    private Long positionId;

    private static final long serialVersionUID = 1L;
}