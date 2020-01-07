package com.dimples.auth.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/7
 */
@Data
@TableName(value = "db_base_permission.tb_menu")
public class Menu implements Serializable {
    /**
     * 菜单/按钮ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 对应路由path
     */
    @TableField(value = "path")
    private String path;

    /**
     * 对应路由组件component
     */
    @TableField(value = "component")
    private String component;

    /**
     * 权限标识
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @TableField(value = "type")
    private String type;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Double orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}