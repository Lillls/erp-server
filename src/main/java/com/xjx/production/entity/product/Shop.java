package com.xjx.production.entity.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xjx.production.plugin.AbstractBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("shop")
@ApiModel(value="Shop", description="")
public class Shop extends AbstractBaseEntity {

    @TableField("name")
    private String name;

    @ApiModelProperty(value = "每天可以上传的最大数量")
    @TableField("count_limit_daily")
    private Integer countLimitDaily;

    @ApiModelProperty(value = "可以上传的总量")
    @TableField("count_limit_total")
    private Integer countLimitTotal;

    @TableField("is_delete")
    private Integer isDelete;


}
