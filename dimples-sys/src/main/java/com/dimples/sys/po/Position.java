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

@ApiModel(value = "com-dimples-sys-po-Position")
@Data
@TableName(value = "db_base_permission.tb_position")
public class Position implements Serializable {
    /**
     * 职位id
     */
    @TableId(value = "position_id", type = IdType.AUTO)
    @ApiModelProperty(value = "职位id")
    private Long positionId;

    /**
     * 职位名称
     */
    @TableField(value = "position_name")
    @ApiModelProperty(value = "职位名称")
    private String positionName;

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