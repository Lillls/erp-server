package com.xjx.production.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.xjx.production.plugin.AbstractBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
@ApiModel(value="Menu", description="菜单表")
public class Menu extends AbstractBaseEntity {

    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "父权限，为空则为子菜单")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "排序，用于菜单顺序")
    @TableField("menu_sort")
    private Integer menuSort;

    @ApiModelProperty(value = "资源名称（操作码）/菜单为前端路由")
    @TableField("resource")
    private String resource;

    @ApiModelProperty(value = "是否为菜单，默认为是（menu是菜单）（page用于按钮的权限）")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "菜单图标")
    @TableField("menu_icon")
    private String menuIcon;

    @ApiModelProperty(value = "状态（close为关闭，open为开启）")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "逻辑删除(1是;0否)")
    @TableField("is_delete")
    private String isDelete;

    @ApiModelProperty(value = "菜单为前端路由")
    @TableField("router_name")
    private String routerName;


}
