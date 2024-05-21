package com.xjx.production.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BasicCategoryInfo", description = "品类基本信息")
public class BasicCategoryInfo {
  @ApiModelProperty("特征")
  private String categoryAlias1;
  @ApiModelProperty("特征")
  private String categoryAlias2;
  @ApiModelProperty("特征")
  private String categoryName;
  private String fixedData;
  @ApiModelProperty("特征")
  private Long categoryId;

}
