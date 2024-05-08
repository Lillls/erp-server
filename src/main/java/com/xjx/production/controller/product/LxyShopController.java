package com.xjx.production.controller.product;


import com.xjx.production.base.R;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.product.LxyShopService;
import com.xjx.production.entity.product.LxyShop;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 *  Restful api
 * </p>
 *
 * @author jzbian
 * @since 2024-05-08
 */
@RestController
@RequestMapping("/lxyShop")
public class LxyShopController {
    /**
     * lxyShop业务处理类
     */
    @Autowired
    LxyShopService lxyShopService;

    @ApiOperation(value = "新增/更新LxyShop", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "lxyShop", value = "待保存的LxyShop", required = true, dataTypeClass = LxyShop.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody LxyShop lxyShop) {
        return R.ok(lxyShopService.saveLxyShop(lxyShop));
    }

    @ApiOperation(value = "新增/更新非空字段LxyShop", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "lxyShop", value = "待保存的LxyShop", required = true, dataTypeClass = LxyShop.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody LxyShop lxyShop) {
        return R.ok(lxyShopService.saveLxyShopNotNull(lxyShop));
    }

    @ApiOperation(value = "根据id返回LxyShop")
    @ApiImplicitParam(name = "id", value = "LxyShop的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<LxyShop> get(@PathVariable(name = "id") Long id) { return R.ok(lxyShopService.getLxyShopById(id));}

    @ApiOperation(value = "根据对象返回带分页的LxyShop")
    @ApiImplicitParam(name = "lxyShop", value = "待查询的LxyShop", required = true, dataTypeClass = LxyShop.class, paramType = "body")
    @PostMapping()
    public R<IPage<LxyShop>> page(@RequestBody LxyShop lxyShop) {
        return R.ok(lxyShopService.pageByLxyShop(lxyShop));
    }

    @ApiOperation(value = "删除LxyShop", notes = "根据主键id删除LxyShop ")
    @ApiImplicitParam(name = "id", value = "LxyShop的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(lxyShopService.deleteLxyShopById(id));
    }

}
