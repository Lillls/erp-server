package com.xjx.production.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.base.R;
import com.xjx.production.dto.category.CategoryPageResult;
import com.xjx.production.entity.category.Category;
import com.xjx.production.entity.category.SizeInfo;
import com.xjx.production.service.category.CategoryService;
import com.xjx.production.service.category.SizeInfoService;
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
@RequestMapping("/category")
public class CategoryController {
  private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

  @Autowired
  CategoryService categoryService;

  @Autowired
  SizeInfoService mSizeInfoService;

  @Autowired
  ForbiddenWordUtils mForbiddenWordUtils;

  @ApiOperation(value = "新增/更新Category", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "category", value = "待保存的Category", required = true,
      dataTypeClass = Category.class, paramType = "body")
  @PutMapping("/addCategory")
  public R<Category> save(@RequestBody Category category) {
    Long categoryId = categoryService.saveCategory(category);
    for (SizeInfo sizeInfo : category.getSizeInfos()) {
      sizeInfo.setCategoryId(categoryId);
    }
    for (int i = 0; i < category.getKeyFeature1().length; i++) {
      category.getKeyFeature1()[i] = mForbiddenWordUtils.checkAndReplace(category.getKeyFeature1()[i]);
    }
    for (int i = 0; i < category.getKeyFeature2().length; i++) {
      category.getKeyFeature2()[i] = mForbiddenWordUtils.checkAndReplace(category.getKeyFeature2()[i]);
    }
    for (int i = 0; i < category.getKeyFeature3().length; i++) {
      category.getKeyFeature3()[i] = mForbiddenWordUtils.checkAndReplace(category.getKeyFeature3()[i]);
    }
    for (int i = 0; i < category.getKeyFeature4().length; i++) {
      category.getKeyFeature4()[i] = mForbiddenWordUtils.checkAndReplace(category.getKeyFeature4()[i]);
    }
    for (int i = 0; i < category.getKeyFeature5().length; i++) {
      category.getKeyFeature5()[i] = mForbiddenWordUtils.checkAndReplace(category.getKeyFeature5()[i]);
    }
    mSizeInfoService.saveSizeList(category.getSizeInfos());
    return R.ok(category);
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
   *
   * @param category
   * @return
   */
  @ApiOperation(value = "根据对象返回带分页的Category")
  @ApiImplicitParam(name = "category", value = "待查询的Category", required = true,
      dataTypeClass = Category.class, paramType = "body")
  @PostMapping("/listByPage")
  public R<IPage<CategoryPageResult>> pageByParam(
      @RequestParam(value = "current", required = false,defaultValue = "-1") int current,
      @RequestParam("size") int size) {
    return R.ok(categoryService.pageByCategory(current, size));
  }

  @PostMapping("/byId")
  public R<CategoryPageResult> categoryById(@RequestParam("id") Long categoryId) {
    return R.ok(categoryService.categoryById(categoryId));
  }

  @ApiOperation(value = "删除Category", notes = "根据主键id删除Category ")
  @ApiImplicitParam(name = "id", value = "Category的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @DeleteMapping("/{id}")
  public R<Boolean> delete(@PathVariable(name = "id") Long id) {
    return R.ok(categoryService.deleteCategoryById(id));
  }


}
