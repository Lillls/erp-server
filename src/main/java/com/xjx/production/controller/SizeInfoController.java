package com.xjx.production.controller;


import com.xjx.production.base.R;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.category.SizeInfoService;
import com.xjx.production.entity.category.SizeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@RestController
@RequestMapping("/categorySize")
public class SizeInfoController {
    /**
     * categorySize业务处理类
     */
    @Autowired
    SizeInfoService categorySizeService;

    @ApiOperation(value = "新增/更新CategorySize", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "categorySize", value = "待保存的CategorySize", required = true, dataTypeClass = SizeInfo.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody SizeInfo categorySize) {
        return R.ok(categorySizeService.saveCategorySize(categorySize));
    }

    @ApiOperation(value = "新增/更新非空字段CategorySize", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "categorySize", value = "待保存的CategorySize", required = true, dataTypeClass = SizeInfo.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody SizeInfo categorySize) {
        return R.ok(categorySizeService.saveCategorySizeNotNull(categorySize));
    }

    @ApiOperation(value = "根据id返回CategorySize")
    @ApiImplicitParam(name = "id", value = "CategorySize的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<SizeInfo> get(@PathVariable(name = "id") Long id) { return R.ok(categorySizeService.getCategorySizeById(id));}

    @ApiOperation(value = "根据对象返回带分页的CategorySize")
    @ApiImplicitParam(name = "categorySize", value = "待查询的CategorySize", required = true, dataTypeClass = SizeInfo.class, paramType = "body")
    @PostMapping()
    public R<IPage<SizeInfo>> page(@RequestBody SizeInfo categorySize) {
        return R.ok(categorySizeService.pageByCategorySize(categorySize));
    }

    @ApiOperation(value = "删除CategorySize", notes = "根据主键id删除CategorySize ")
    @ApiImplicitParam(name = "id", value = "CategorySize的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(categorySizeService.deleteCategorySizeById(id));
    }

}
