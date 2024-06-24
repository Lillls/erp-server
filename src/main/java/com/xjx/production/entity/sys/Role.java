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
 * 角色表
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@ApiModel(value="Role", description="角色表")
public class Role extends AbstractBaseEntity {

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "逻辑删除(1是;0否)")
    @TableField("is_delete")
    private String isDelete;

    @ApiModelProperty(value = "状态（close为关闭，open为开启）")
    @TableField("status")
    private String status;


}
