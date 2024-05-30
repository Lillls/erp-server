package com.xjx.production.repository.product;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xjx.production.entity.product.Product;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

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

  /**
   * 根据parent_id查询子产品集合
   * @param parentId
   * @return
   */
  public List<Product> queryByParentId(Long parentId){
      LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(Product::getParentId, parentId)
              .eq(Product::getIsDelete, 0);
      return list(wrapper);
  }
}
