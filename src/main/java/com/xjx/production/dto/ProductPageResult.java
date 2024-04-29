package com.xjx.production.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品图片地址，以逗号分隔")
    private String[] descriptionPictures;

    @ApiModelProperty("拓展字段1")
    private String keyFeature1;

    @ApiModelProperty("拓展字段2")
    private String keyFeature2;

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

    @ApiModelProperty(value = "更新人姓名")
    private String updatorName;

    @ApiModelProperty(value = "更新人账号")
    private Long updator;

    @ApiModelProperty("尺寸信息")
    private BaseSizeInfo sizeInfo;

    @Data
    @ApiModel(value = "BaseSizeInfo", description = "尺寸基本信息")
    static class BaseSizeInfo{

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
    }
}
