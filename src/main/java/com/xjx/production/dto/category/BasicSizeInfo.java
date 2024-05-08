package com.xjx.production.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "BaseSizeInfo", description = "尺寸基本信息")
public class BasicSizeInfo {

    @ApiModelProperty("主键")
    private Long id;
    @ApiModelProperty("对应品类主键")
    private Long categoryId;

    @ApiModelProperty("宽")
    private BigDecimal width;

    @ApiModelProperty("高")
    private BigDecimal height;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("")
    private BigDecimal packageWeight;

    @ApiModelProperty("特征")
    private String symbol;

    @ApiModelProperty("尺寸对应图片url")
    private String sizeUrl;

}
