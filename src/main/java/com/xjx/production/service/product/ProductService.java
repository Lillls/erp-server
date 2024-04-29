package com.xjx.production.service.product;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjx.production.dto.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.repository.product.ProductMapper;
import com.xjx.production.repository.product.ProductRepository;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * Product业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class ProductService {

  /**
   * productMapper
   */
  @Autowired
  ProductMapper productMapper;

  /**
   * productRepository
   */
  @Autowired
  ProductRepository productRepository;

  /**
   * 保存/更新对象
   *
   * @param product 待处理对象
   * @return Long 主键
   */
  @Transactional
  public Long saveProduct(Product product) {
    productRepository.saveOrUpdate(product);
    return product.getId();
  }

  /**
   * 保存/更新对象中的非空值
   *
   * @param product 待处理对象
   * @return Long 主键
   */
  @Transactional
  public Long saveProductNotNull(Product product) {
    productRepository.saveOrUpdatePatch(product);
    return product.getId();
  }

  /**
   * 根据主键查询对象
   *
   * @param id 主键
   * @return Product 对象实体
   */
  public Product getProductById(Long id) {
    return productRepository.getById(id);
  }

  /**
   * 根据条件查询分页集合
   *
   * @param product 实体参宿对象
   * @return IPage<Product> 分页对象
   */
  public IPage<Product> pageByProduct(Product product) {
    return productRepository.pageByProduct(product);
  }

  /**
   * 查询所有数据
   *
   * @return List<Product> 数据结果集合
   */
  public List<Product> queryProduct() {
    return productRepository.list(null);
  }

  /**
   * 根据id删除对象
   *
   * @param id 主键id
   * @return 是否删除成功 true：成功，false：失败
   */
  public Boolean deleteProductById(Long id) {
    return productRepository.removeById(id);
  }

  /**
   * 商品分页查询
   * @param product
   * @return
   */
  public IPage<ProductPageResult> selectProductWithSize(Product product) {
    IPage<ProductPageResult> page = new Page<>(product.getCurrent(), product.getSize());
    return productMapper.selectProductWithSize(page, product);
  }

}
