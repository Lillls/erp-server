package com.xjx.production.dto.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xjx.production.entity.sys.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MenuDto {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "排序，用于菜单顺序")
    private Integer menuSort;

    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;
    @ApiModelProperty(value = "菜单为前端路由")
    private String routerName;

    @ApiModelProperty(value = "子菜单")
    private List<MenuDto> childMenu;

}
