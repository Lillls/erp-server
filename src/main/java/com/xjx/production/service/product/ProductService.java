package com.xjx.production.service.product;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjx.production.dto.product.ProductPageResult;
import com.xjx.production.entity.product.Product;
import com.xjx.production.repository.product.ProductMapper;
import com.xjx.production.repository.product.ProductRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

  public boolean saveProductList(List<Product> product) {
    return productRepository.saveBatch(product);
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

  public List<Product> listByIds(List<Long> ids) {
    return productRepository.listByIds(ids);
  }

  public boolean updateBatch(List<Product> productList) {
    return productRepository.saveOrUpdateBatch(productList);
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
   *
   * @return
   */
  public IPage<ProductPageResult> selectProductWithSizePage(Long userId, int current, int size) {
    IPage<ProductPageResult> page = new Page<>(current, size);
    return productMapper.selectProductWithSizePage(userId, page);
  }

  public void mergeProduct(List<Long> ids, String parentSku, Long parentId) {
    productMapper.mergeProduct(StringUtils.join(ids, ","), parentSku, parentId);
  }


  /**
   * 根据id查查询带有Child集合的商品信息
   * @param id
   * @return
   */
  public ProductPageResult queryWithChild(Long id){
    ProductPageResult res = productMapper.selectProductWithSize(id);
    Optional.ofNullable(res).ifPresent(item -> {
      if(StringUtils.isNotEmpty(item.getParentage())
              && item.getParentage().equalsIgnoreCase("Parent")){
        item.setChilds(queryByParentId(item.getId()));
      }
    });
    return res;
  }

  /**
   * 根据parent_id查询子产品集合
   * @param parentId
   * @return
   */
  public List<Product> queryByParentId(Long parentId){
    return productRepository.queryByParentId(parentId);
  }
}
