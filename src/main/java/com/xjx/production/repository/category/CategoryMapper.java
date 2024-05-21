package com.xjx.production.repository.category;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjx.production.dto.category.CategoryPageResult;
import com.xjx.production.entity.category.Category;
import com.xjx.production.entity.product.Product;
import com.xjx.production.plugin.MyBaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Component
public interface CategoryMapper extends MyBaseMapper<Category> {

  IPage<CategoryPageResult> pageByParam(Page<CategoryPageResult> page);

  CategoryPageResult categoryById(@Param("categoryId") Long categoryId);
}
