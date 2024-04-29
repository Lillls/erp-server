package com.xjx.production.repository.product;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
  public IPage<Product> selectProductWithSize(IPage<Product> page,Product product);
}
