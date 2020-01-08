package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com-dimples-sys-po-UGroup")
@Data
@TableName(value = "db_base_permission.tb_u_group")
public class UGroup implements Serializable {
    /**
     * 用户组id
     */
    @TableId(value = "u_group_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户组id")
    private Long uGroupId;

    /**
     * 用户组名
     */
    @TableField(value = "group_name")
    @ApiModelProperty(value = "用户组名")
    private String groupName;

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
}