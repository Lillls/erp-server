package com.xjx.production.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2024-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ums_member")
@ApiModel(value="UmsMember", description="")
public class UmsMember extends AbstractBaseEntity {

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户是否过期(0：未过期，1：已过期)")
    @TableField("account_non_Expired")
    private Boolean accountNonExpired;

    @ApiModelProperty(value = "账户是否锁定(0：未锁定，1：已锁定)")
    @TableField("account_non_Locked")
    private Boolean accountNonLocked;

    @ApiModelProperty(value = "密码是否过期(0：已过期，1：未过期)")
    @TableField("credentials_non_Expired")
    private Boolean credentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用(0：可用，1：不可用)")
    @TableField("enable")
    private Boolean enable;

    @ApiModelProperty(value = "是否删除(0：未删除，1：已删除)")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "jwt，过期时间30分钟")
    @TableField("token")
    private String token;

}
