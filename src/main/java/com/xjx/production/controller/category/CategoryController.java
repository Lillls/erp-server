package com.xjx.production.controller.category;


import com.xjx.production.base.R;
import com.xjx.production.dto.category.CategoryPageResult;
import com.xjx.production.entity.category.SizeInfo;
import com.xjx.production.entity.product.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.category.CategoryService;
import com.xjx.production.entity.category.Category;
import com.xjx.production.service.category.SizeInfoService;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;


/**
 * <p>
 * Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
  private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

  @Autowired
  CategoryService categoryService;

  @Autowired
  SizeInfoService mSizeInfoService;

  @ApiOperation(value = "新增/更新Category", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "category", value = "待保存的Category", required = true,
      dataTypeClass = Category.class, paramType = "body")
  @PutMapping
  public R<Long> save(@RequestBody Category category) {
    return R.ok(categoryService.saveCategory(category));
  }

  @ApiOperation(value = "新增/更新非空字段Category",
      notes = "id为空是新建，非空是更新;只更新非空字段")
  @ApiImplicitParam(name = "category", value = "待保存的Category", required = true,
      dataTypeClass = Category.class, paramType = "body")
  @PatchMapping
  public R<Long> savePatch(@RequestBody Category category) {
    return R.ok(categoryService.saveCategoryNotNull(category));
  }

  @ApiOperation(value = "根据id返回Category")
  @ApiImplicitParam(name = "id", value = "Category的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @GetMapping("/{id}")
  public R<Category> get(@PathVariable(name = "id") Long id) {
    return R.ok(categoryService.getCategoryById(id));
  }

  /**
   * 品类分页查询
   * @param category
   * @return
   */
  @ApiOperation(value = "根据对象返回带分页的Category")
  @ApiImplicitParam(name = "category", value = "待查询的Category", required = true, dataTypeClass = Category.class, paramType = "body")
  @PostMapping("/pageByParam")
  public R<IPage<CategoryPageResult>> pageByParam(@RequestBody Category category) {
    return R.ok(categoryService.pageByCategory(category));
  }

  @ApiOperation(value = "删除Category", notes = "根据主键id删除Category ")
  @ApiImplicitParam(name = "id", value = "Category的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @DeleteMapping("/{id}")
  public R<Boolean> delete(@PathVariable(name = "id") Long id) {
    return R.ok(categoryService.deleteCategoryById(id));
  }


}
