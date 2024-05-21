package com.xjx.production.entity.category;

import com.baomidou.mybatisplus.annotation.TableField;
import java.math.BigDecimal;
import java.util.BitSet;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xjx.production.plugin.AbstractBaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("size_price")
@ApiModel(value = "SizeInfo", description = "")
public class SizeInfo extends AbstractBaseEntity {

  @TableField("width")
  private BigDecimal width;

  @TableField("height")
  private BigDecimal height;

  @TableField("unit")
  private String unit;

  @TableField("category_id")
  private Long categoryId;

  @TableField("package_weight")
  private Double packageWeight;

  @TableField("size_url")
  private String sizeUrl;

  @TableField("symbol")
  private String symbol;

  @TableField("price")
  private BigDecimal price;

  @JsonIgnore
  @TableField("is_delete")
  private Integer isDelete;

}
