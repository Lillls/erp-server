package com.xjx.production.repository.product;

import com.xjx.production.entity.product.Product;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  Product数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class ProductRepository extends BaseRepository<ProductMapper, Product> {

    /**
     * 查询分页对象
     * @param product 条件查询对象
     * @return IPage<Product>
     */
    public IPage<Product> pageByProduct(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(product);
        return pageAndSort(queryWrapper, product);
    }

  public IPage<Product> selectProductWithSize(Product product) {
    QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
    queryWrapper.setEntity(product);
    return pageAndSort(queryWrapper, product);
  }
}
