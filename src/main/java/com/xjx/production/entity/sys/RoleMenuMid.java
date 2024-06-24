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
 * 角色与菜单关联表
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu_mid")
@ApiModel(value="RoleMenuMid", description="角色与菜单关联表")
public class RoleMenuMid extends AbstractBaseEntity {

    @ApiModelProperty(value = "角色主键")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "权限主键")
    @TableField("menu_id")
    private Long menuId;

    @ApiModelProperty(value = "逻辑删除(1是;0否)")
    @TableField("is_delete")
    private String isDelete;


}
