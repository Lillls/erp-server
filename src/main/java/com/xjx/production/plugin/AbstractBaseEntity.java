package com.xjx.production.plugin;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体父类
 */
@Data
public abstract class AbstractBaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * ID
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 创建时间
   */
  @TableField(value = "create_time", fill = FieldFill.INSERT, whereStrategy = FieldStrategy.NEVER)
  @ApiModelProperty(value = "创建时间", example = "null")
  public Date createTime;
  /**
   * 修改时间
   */
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE,
      whereStrategy = FieldStrategy.NEVER)
  @ApiModelProperty(value = "修改时间", example = "null")
  private Date updateTime;

  @TableField(value = "creator_name", fill = FieldFill.INSERT)
  @ApiModelProperty(value = "创建人姓名")
  private String creatorName;

  @TableField(value = "creator", fill = FieldFill.INSERT)
  @ApiModelProperty(value = "创建人账号")
  private Long creator;
  //
  //    @TableField(value = "creator_org", fill = FieldFill.INSERT)
  //    @ApiModelProperty(value = "创建人公司代码")
  //    @JsonIgnore
  //    private String creatorOrg;
  //
  //    @TableField(value = "creator_department", fill = FieldFill.INSERT)
  //    @ApiModelProperty(value = "创建人部门ID")
  //    @JsonIgnore
  //    private String creatorDepartment;
  //
  @TableField(value = "updator_name", fill = FieldFill.UPDATE)
  @ApiModelProperty(value = "更新人姓名")
  private String updatorName;

  @TableField(value = "updator", fill = FieldFill.UPDATE)
  @ApiModelProperty(value = "更新人账号")
  @JsonIgnore
  private Long updator;
  //
  //    @TableField(value = "updator_org", fill = FieldFill.UPDATE)
  //    @ApiModelProperty(value = "更新人部门")
  //    @JsonIgnore
  //    private String updatorOrg;
  //
  //    @TableField(value = "updator_department", fill = FieldFill.UPDATE)
  //    @ApiModelProperty(value = "更新人部门ID")
  //    @JsonIgnore
  //    private String updatorDepartment;

  /**
   * 页数从1开始
   */
  @TableField(exist = false)
  @ApiModelProperty(value = "当前页", example = "1")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private int current;
  /**
   * 每页个数
   */
  @TableField(exist = false)
  @ApiModelProperty(value = "每页个数", example = "15")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private int size;

  /**
   * 排序字段 格式 time&asc,name&desc
   */
  @TableField(exist = false)
  @ApiModelProperty(value = "排序")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String sort;

}

