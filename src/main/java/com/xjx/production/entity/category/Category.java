package com.xjx.production.entity.category;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xjx.production.plugin.AbstractBaseEntity;

import apple.laf.JRSUIConstants;
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
@TableName(value = "category", autoResultMap = true)
@ApiModel(value = "Category", description = "")
public class Category extends AbstractBaseEntity {
  @TableField("category_name")
  private String categoryName;
  @TableField("category_alias1")
  private String categoryAlias1;
  @TableField("category_alias2")
  private String categoryAlias2;
  @TableField(value = "key_feature1", typeHandler = JacksonTypeHandler.class)
  private String[] keyFeature1;
  @TableField(value = "key_feature2", typeHandler = JacksonTypeHandler.class)
  private String[] keyFeature2;
  @TableField(value = "key_feature3", typeHandler = JacksonTypeHandler.class)
  private String[] keyFeature3;
  @TableField(value = "key_feature4", typeHandler = JacksonTypeHandler.class)
  private String[] keyFeature4;
  @TableField(value = "key_feature5", typeHandler = JacksonTypeHandler.class)
  private String[] keyFeature5;
  @TableField(value = "fixed_data")
  private String fixedData;
  @TableField(value = "attribute")
  private String attribute;
  @TableField(value = "template_header")
  private String templateHeader;
  @TableField(exist = false)
  private List<SizeInfo> sizeInfos;
  @JsonIgnore
  @TableField(value = "is_delete")
  private Integer isDelete;
}
