package com.xjx.production.repository.product;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.dto.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.plugin.MyBaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Component
public interface ProductMapper extends MyBaseMapper<Product> {

  /**
   * 商品分页查询
   * @param page
   * @param product
   * @return
   */
  IPage<ProductPageResult> selectProductWithSize(IPage<ProductPageResult> page, Product product);

}
