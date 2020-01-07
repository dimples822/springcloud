package com.dimples.sys.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@ApiModel(value = "com-dimples-sys-po-MenuRole")
@Data
@TableName(value = "db_base_permission.tb_menu_role")
public class MenuRole implements Serializable {
    @TableField(value = "role_id")
    @ApiModelProperty(value = "")
    private Long roleId;

    @TableField(value = "menu_id")
    @ApiModelProperty(value = "")
    private Long menuId;

    private static final long serialVersionUID = 1L;

}