package com.xjx.production.entity.product;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
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
@TableName(value = "lxy_product", autoResultMap = true)
@ApiModel(value = "Product", description = "")
public class Product extends AbstractBaseEntity {
  @TableField("category")
  private String category;

  @TableField("sku")
  private String sku;

  @TableField("parent_sku")
  private String parentSku;

  @TableField("description")
  private String description;

  @TableField("caption")
  private String caption;

  @TableField("design_number")
  private String designNumber;

  @TableField("main_image_url")
  private String mainImageUrl;

  @TableField("parentage")
  private String parentage;

  @TableField("price")
  private BigDecimal price;

  @TableField(value = "description_pictures", typeHandler = JacksonTypeHandler.class)
  private String[] descriptionPictures;

  @TableField("key_feature1")
  private String keyFeature1;

  @TableField("key_feature2")
  private String keyFeature2;

  @TableField("key_feature3")
  private String keyFeature3;

  @TableField("key_feature4")
  private String keyFeature4;

  @TableField("key_feature5")
  private String keyFeature5;

  @TableField("generic_keywords")
  private String genericKeywords;

  @TableField("category_id")
  private Long categoryId;

  @TableField("parent_id")
  private Long parentId;

  @TableField("size_id")
  private Long sizeId;

  @TableField("export_count")
  private Integer exportCount;

  @TableField("extra_info")
  private String extraInfo;

  @JsonIgnore
  @TableField("is_delete")
  private Integer isDelete;

  @TableField("main_element")
  private String mainElement;

/*//  @TableField("package_weight")
//  private Double packageWeight;

  @TableField("size_url")
  private String sizeUrl;

  @TableField("symbol")
  private String symbol;

  @TableField("width")
  private BigDecimal width;

  @TableField("height")
  private BigDecimal height;

  @TableField("unit")
  private String unit;*/
}
