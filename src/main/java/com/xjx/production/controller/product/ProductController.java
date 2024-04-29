package com.xjx.production.controller.product;


import java.util.List;

import com.xjx.production.dto.ProductPageResult;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.base.R;
import com.xjx.production.entity.product.Product;
import com.xjx.production.service.product.ProductService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@RestController
@RequestMapping("/product")
public class ProductController {
  /**
   * product业务处理类
   */
  @Autowired
  ProductService productService;

  @ApiOperation(value = "新增/更新Product", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "addProduct", value = "待保存的Product", required = true,
      dataTypeClass = Product.class, paramType = "body")
  @PutMapping("/addProduct")
  public R<Product> save(@RequestBody Product product) {
    Long data = productService.saveProduct(product);
    product.setId(data);
    return R.ok(product);
  }

  @ApiOperation(value = "新增/更新Product", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "addProduct", value = "待保存的Product", required = true,
      dataTypeClass = Product.class, paramType = "body")
  @PutMapping("/addProductList")
  public R<Product> saveList(@RequestBody List<Product> productList) {
    for (Product product : productList) {
      if (TextUtils.isEmpty(product.getCategory()) || product.getCategoryId() == null) {
        return R.fail("Category不能为空");
      }
      Long data = productService.saveProduct(product);
      product.setId(data);
    }
    return R.ok();
  }

  @ApiOperation(value = "新增/更新非空字段Product",
      notes = "id为空是新建，非空是更新;只更新非空字段")
  @ApiImplicitParam(name = "updateProduct", value = "待保存的Product", required = true,
      dataTypeClass = Product.class, paramType = "body")
  @PatchMapping
  public R<Long> savePatch(@RequestBody Product product) {
    return R.ok(productService.saveProductNotNull(product));
  }

  @ApiOperation(value = "根据id返回Product")
  @ApiImplicitParam(name = "id", value = "Product的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @GetMapping("/{id}")
  public R<Product> get(@PathVariable(name = "id") Long id) {
    return R.ok(productService.getProductById(id));
  }

  @ApiOperation(value = "商品分页查询")
  @ApiImplicitParam(name = "product", value = "product", required = true, dataTypeClass = Product.class, paramType = "body")
  @PostMapping("/pageByParam")
  public R<IPage<ProductPageResult>> pageByParam(@RequestBody Product product) {
    return R.ok(productService.selectProductWithSize(product));
  }

  @ApiOperation(value = "删除Product", notes = "根据主键id删除Product ")
  @ApiImplicitParam(name = "id", value = "Product的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @DeleteMapping("/{id}")
  public R<Boolean> delete(@PathVariable(name = "id") Long id) {
    return R.ok(productService.deleteProductById(id));
  }

}
