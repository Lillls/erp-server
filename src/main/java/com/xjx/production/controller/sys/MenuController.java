package com.xjx.production.controller.sys;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.MenuService;
import com.xjx.production.entity.sys.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.production.base.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 * 菜单表 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    /**
     * menu业务处理类
     */
    @Autowired
    MenuService menuService;

    @ApiOperation(value = "新增/更新Menu", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "menu", value = "待保存的Menu", required = true, dataTypeClass = Menu.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody Menu menu) {
        return R.ok(menuService.saveMenu(menu));
    }

    @ApiOperation(value = "新增/更新非空字段Menu", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "menu", value = "待保存的Menu", required = true, dataTypeClass = Menu.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody Menu menu) {
        return R.ok(menuService.saveMenuNotNull(menu));
    }

    @ApiOperation(value = "根据id返回Menu")
    @ApiImplicitParam(name = "id", value = "Menu的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<Menu> get(@PathVariable(name = "id") Long id) { return R.ok(menuService.getMenuById(id));}

    @ApiOperation(value = "根据对象返回带分页的Menu")
    @ApiImplicitParam(name = "menu", value = "待查询的Menu", required = true, dataTypeClass = Menu.class, paramType = "body")
    @PostMapping()
    public R<IPage<Menu>> page(@RequestBody Menu menu) {
        return R.ok(menuService.pageByMenu(menu));
    }

    @ApiOperation(value = "删除Menu", notes = "根据主键id删除Menu ")
    @ApiImplicitParam(name = "id", value = "Menu的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(menuService.deleteMenuById(id));
    }

}
