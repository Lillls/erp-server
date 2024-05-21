package com.xjx.production.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.base.R;
import com.xjx.production.entity.product.Shop;
import com.xjx.production.service.product.ShopService;
import com.xjx.production.service.user.UmsMemberService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
  /**
   * Shop业务处理类
   */
  @Autowired
  ShopService shopService;

  @Autowired
  UmsMemberService umsMemberService;

  @ApiOperation(value = "新增/更新Shop", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "/addShop", value = "待保存的Shop", required = true,
      dataTypeClass = Shop.class, paramType = "body")
  @PutMapping("/addShop")
  public R<Shop> save(@RequestBody Shop shop) {
    shop.setCreator(umsMemberService.getCurrentUser().getId());
    shop.setCreatorName(umsMemberService.getCurrentUser().getUserName());
    shopService.saveShop(shop);
    return R.ok(shop);
  }

  @ApiOperation(value = "根据对象返回带分页的Shop")
  @ApiImplicitParam(name = "shop", value = "待查询的Shop", required = true, dataTypeClass = Shop.class,
      paramType = "body")
  @PostMapping("/listByPage")
  public R<IPage<Shop>> page(@RequestBody Shop shop) {
    shop.setCreator(umsMemberService.getCurrentUser().getId());
    return R.ok(shopService.pageByShop(shop));
  }

}
