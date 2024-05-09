package com.xjx.production.repository.product;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.dto.product.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.plugin.MyBaseMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
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
public interface ProductMapper extends MyBaseMapper<Product> {

  /**
   * 商品分页查询
   *
   * @param page
   * @param product
   * @return
   */
  IPage<ProductPageResult> selectProductWithSize(IPage<ProductPageResult> page, Product product);

  @Update(
      "update product set parent_sku = #{parentSku},parent_id = #{parentId} where id in (${ids})")
  void mergeProduct(@Param("ids") String ids, @Param("parentSku") String parentSku,
      @Param("parentId") Long parentId);

}
