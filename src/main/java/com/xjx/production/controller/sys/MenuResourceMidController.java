package com.xjx.production.controller.sys;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.MenuResourceMidService;
import com.xjx.production.entity.sys.MenuResourceMid;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.production.base.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 * 菜单与资源关联表 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/menuResourceMid")
public class MenuResourceMidController {
    /**
     * menuResourceMid业务处理类
     */
    @Autowired
    MenuResourceMidService menuResourceMidService;

    @ApiOperation(value = "新增/更新MenuResourceMid", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "menuResourceMid", value = "待保存的MenuResourceMid", required = true, dataTypeClass = MenuResourceMid.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody MenuResourceMid menuResourceMid) {
        return R.ok(menuResourceMidService.saveMenuResourceMid(menuResourceMid));
    }

    @ApiOperation(value = "新增/更新非空字段MenuResourceMid", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "menuResourceMid", value = "待保存的MenuResourceMid", required = true, dataTypeClass = MenuResourceMid.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody MenuResourceMid menuResourceMid) {
        return R.ok(menuResourceMidService.saveMenuResourceMidNotNull(menuResourceMid));
    }

    @ApiOperation(value = "根据id返回MenuResourceMid")
    @ApiImplicitParam(name = "id", value = "MenuResourceMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<MenuResourceMid> get(@PathVariable(name = "id") Long id) { return R.ok(menuResourceMidService.getMenuResourceMidById(id));}

    @ApiOperation(value = "根据对象返回带分页的MenuResourceMid")
    @ApiImplicitParam(name = "menuResourceMid", value = "待查询的MenuResourceMid", required = true, dataTypeClass = MenuResourceMid.class, paramType = "body")
    @PostMapping()
    public R<IPage<MenuResourceMid>> page(@RequestBody MenuResourceMid menuResourceMid) {
        return R.ok(menuResourceMidService.pageByMenuResourceMid(menuResourceMid));
    }

    @ApiOperation(value = "删除MenuResourceMid", notes = "根据主键id删除MenuResourceMid ")
    @ApiImplicitParam(name = "id", value = "MenuResourceMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(menuResourceMidService.deleteMenuResourceMidById(id));
    }

}
