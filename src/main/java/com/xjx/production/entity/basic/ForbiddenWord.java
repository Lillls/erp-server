package com.xjx.production.entity.basic;

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
 * 
 * </p>
 *
 * @author xjx
 * @since 2024-05-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("forbidden_word")
@ApiModel(value="ForbiddenWord", description="")
public class ForbiddenWord extends AbstractBaseEntity {

    @TableField("word")
    private String word;

    @TableField("is_delete")
    private Integer isDelete;


}
