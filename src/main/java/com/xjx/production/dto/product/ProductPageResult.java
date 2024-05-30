package com.xjx.production.dto.product;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xjx.production.dto.category.BasicCategoryInfo;
import com.xjx.production.dto.category.BasicSizeInfo;

import com.xjx.production.entity.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "ProductPageResult", description = "商品分页列表返回结果")
public class ProductPageResult {

  @ApiModelProperty("主键")
  private Long id;

  @ApiModelProperty("商品类别")
  private String category;

  @ApiModelProperty("")
  private String sku;

  @ApiModelProperty("")
  private String parentSku;

  @ApiModelProperty("商品描述")
  private String description;

  @ApiModelProperty("标题")
  private String caption;

  @ApiModelProperty("商品价格")
  private BigDecimal price;

  @ApiModelProperty(value = "商品图片地址，以逗号分隔")
  private String[] descriptionPictures;

  @ApiModelProperty("拓展字段1")
  private String keyFeature1;

  @ApiModelProperty("拓展字段2")
  private String keyFeature2;

  @ApiModelProperty("设计编号")
  private String designNumber;

  @ApiModelProperty("主图")
  private String mainImageUrl;

  @ApiModelProperty("拓展字段3")
  private String keyFeature3;

  @ApiModelProperty("拓展字段4")
  private String keyFeature4;

  @ApiModelProperty("拓展字段5")
  private String keyFeature5;

  @ApiModelProperty("")
  private String genericKeywords;

  @ApiModelProperty("商品类别id")
  private Long categoryId;

  @ApiModelProperty("数量")
  private Integer exportCount;

  @ApiModelProperty("信息")
  private String extraInfo;

  @JsonIgnore
  @ApiModelProperty("是否删除 0:已删除 1:未删除")
  private Integer isDelete;

  @ApiModelProperty("")
  private String mainElement;

  @ApiModelProperty(value = "创建时间")
  public Date createTime;

  @ApiModelProperty(value = "修改时间")
  private Date updateTime;

  @ApiModelProperty(value = "创建人姓名")
  private String creatorName;

  @ApiModelProperty(value = "创建人账号")
  private Long creator;

  @ApiModelProperty(value = "尺寸信息")
  private Long sizeId;

  private Long parentId;

  @ApiModelProperty(value = "更新人姓名")
  private String updatorName;

  private String parentage;

  @ApiModelProperty(value = "更新人账号")
  private Long updator;

  @ApiModelProperty("尺寸信息")
  private BasicSizeInfo sizeInfo;

  @ApiModelProperty("品类信息")
  private BasicCategoryInfo categoryInfo;

  @ApiModelProperty("Child产品列表")
  private List<Product> childs;
}
