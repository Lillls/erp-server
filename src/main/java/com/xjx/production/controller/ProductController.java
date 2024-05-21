package com.xjx.production.controller;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjx.production.base.R;
import com.xjx.production.dto.product.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.service.product.ProductService;
import com.xjx.production.service.user.UmsMemberService;
import com.xjx.production.utils.ForbiddenWordUtils;

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

  @Autowired
  UmsMemberService umsMemberService;

  @Autowired
  ForbiddenWordUtils mForbiddenWordUtils;

  @Transactional
  @ApiOperation(value = "新增/更新Product", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "addProduct", value = "待保存的Product", required = true,
      dataTypeClass = Product.class, paramType = "body")
  @PutMapping("/addProductList")
  public R<IPage<Product>> saveList(@RequestBody List<Product> productList) {
    if (productList == null || productList.isEmpty()) {
      return R.fail("数据不能为空");
    }
    Long userId = umsMemberService.getCurrentUser().getId();
    String userName = umsMemberService.getCurrentUser().getUserName();
    Product childProduct = productList.get(0);
    String parentSku = childProduct.getDesignNumber() + "ParentSKU";
    Product parentProduct = new Product();
    parentProduct.setParentage("Parent");
    parentProduct.setSku(parentSku);
    parentProduct.setCategory(childProduct.getCategory());
    parentProduct.setCategoryId(childProduct.getCategoryId());
    Long parentId = productService.saveProduct(parentProduct);

    for (Product product : productList) {
      product.setCreator(userId);
      product.setCreatorName(userName);
      product.setCreateTime(new Date());
      if (TextUtils.isEmpty(product.getCategory()) || product.getCategoryId() == null) {
        return R.fail("Category不能为空");
      }
      product.setParentSku(parentSku);
      product.setParentage("Child");
      product.setParentId(parentId);
      product.setDescription(mForbiddenWordUtils.checkAndReplace(product.getDescription()));
      product.setCaption(mForbiddenWordUtils.checkAndReplace(product.getCaption()));
      product.setGenericKeywords(mForbiddenWordUtils.checkAndReplace(product.getGenericKeywords()));
      product.setMainElement(mForbiddenWordUtils.checkAndReplace(product.getMainElement()));

    }

    productService.saveProductList(productList);
    Page<Product> productIPage = new Page<>();
    return R.ok(productIPage.setRecords(productList));
  }

  @ApiOperation(value = "商品分页查询")
  @ApiImplicitParam(name = "product", value = "product", required = true,
      dataTypeClass = Page.class, paramType = "body")
  @PostMapping("/listByPage")
  public R<IPage<ProductPageResult>> pageByParam(
      @RequestParam(value = "current", required = false, defaultValue = "-1") int current,
      @RequestParam("size") int size) {
    Long userId = umsMemberService.getCurrentUser().getId();
    IPage<ProductPageResult> data = productService.selectProductWithSize(userId, current, size);
    for (ProductPageResult record : data.getRecords()) {
      if (Objects.equals(record.getParentage(), "Parent")) {
        record.setSizeInfo(null);
      }
    }
    return R.ok(data);
  }

}
