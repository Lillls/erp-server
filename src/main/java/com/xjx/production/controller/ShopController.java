package com.xjx.production.controller;


import com.xjx.production.base.R;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.product.ShopService;
import com.xjx.production.entity.product.Shop;
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
 * @since 2024-05-08
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    /**
     * lxyShop业务处理类
     */
    @Autowired
    ShopService shopService;

    @ApiOperation(value = "新增/更新LxyShop", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "lxyShop", value = "待保存的LxyShop", required = true, dataTypeClass = Shop.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody Shop shop) {
        return R.ok(shopService.saveShop(shop));
    }

    @ApiOperation(value = "新增/更新非空字段LxyShop", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "lxyShop", value = "待保存的LxyShop", required = true, dataTypeClass = Shop.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody Shop shop) {
        return R.ok(shopService.saveShopNotNull(shop));
    }

    @ApiOperation(value = "根据id返回LxyShop")
    @ApiImplicitParam(name = "id", value = "LxyShop的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<Shop> get(@PathVariable(name = "id") Long id) { return R.ok(shopService.getShopById(id));}

    @ApiOperation(value = "根据对象返回带分页的LxyShop")
    @ApiImplicitParam(name = "lxyShop", value = "待查询的LxyShop", required = true, dataTypeClass = Shop.class, paramType = "body")
    @PostMapping("/listByPage")
    public R<IPage<Shop>> page(@RequestBody Shop shop) {
        return R.ok(shopService.pageByShop(shop));
    }

    @ApiOperation(value = "删除LxyShop", notes = "根据主键id删除LxyShop ")
    @ApiImplicitParam(name = "id", value = "LxyShop的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(shopService.deleteShopById(id));
    }

}
