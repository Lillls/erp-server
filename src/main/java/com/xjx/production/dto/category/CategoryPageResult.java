package com.xjx.production.dto.category;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @since 2024-04-17
 */
@Data
@ApiModel(value = "CategoryPageResult", description = "商品品类分页查询结果")
public class CategoryPageResult {

  @ApiModelProperty("主键")
  private Long id;
  @ApiModelProperty("品类名称")
  private String categoryName;

  @ApiModelProperty("品类别名")
  private String categoryAlias1;

  @ApiModelProperty("品类别名")
  private String categoryAlias2;

  private String attribute;

  private String fixedData;

  private String templateHeader;

  @ApiModelProperty(value = "拓展字段1")
  private String[] keyFeature1;

  @ApiModelProperty(value = "拓展字段2")
  private String[] keyFeature2;

  @ApiModelProperty(value = "拓展字段3")
  private String[] keyFeature3;

  @ApiModelProperty(value = "拓展字段4")
  private String[] keyFeature4;

  @ApiModelProperty(value = "拓展字段5")
  private String[] keyFeature5;

  @ApiModelProperty(value = "尺寸信息")
  private List<BasicSizeInfo> sizeInfos;

  @JsonIgnore
  @ApiModelProperty(value = "是否删除 0:未删除 1:已删除")
  private Integer isDelete;

  @ApiModelProperty(value = "创建时间")
  public Date createTime;

  @ApiModelProperty(value = "修改时间")
  private Date updateTime;

  @ApiModelProperty(value = "创建人姓名")
  private String creatorName;

  @ApiModelProperty(value = "创建人账号")
  private Long creator;

  @ApiModelProperty(value = "更新人姓名")
  private String updatorName;

  @ApiModelProperty(value = "更新人账号")
  private Long updator;
}
