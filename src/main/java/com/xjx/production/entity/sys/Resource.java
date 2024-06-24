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
 * 后端访问资源
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_resource")
@ApiModel(value="Resource", description="后端访问资源")
public class Resource extends AbstractBaseEntity {

    @ApiModelProperty(value = "资源名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "资源路径")
    @TableField("pattern")
    private String pattern;

    @ApiModelProperty(value = "请求方式")
    @TableField("pattern_method")
    private String patternMethod;

    @ApiModelProperty(value = "资源类型，（inside内部）（outside外部）（other通用）")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "状态（close为关闭，open为开启）")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "逻辑删除(1是;0否)")
    @TableField("is_delete")
    private String isDelete;


}
