package com.xjx.production.service.category;

import com.xjx.production.entity.category.SizeInfo;
import com.xjx.production.repository.category.SizeInfoMapper;
import com.xjx.production.repository.category.SizeInfoRepository;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * CategorySize业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class SizeInfoService {

  /**
   * categorySizeMapper
   */
  @Autowired
  SizeInfoMapper categorySizeMapper;

  /**
   * categorySizeRepository
   */
  @Autowired
  SizeInfoRepository categorySizeRepository;

  /**
   * 保存/更新对象
   *
   * @param categorySize 待处理对象
   * @return Long 主键
   */
  @Transactional
  public Long saveCategorySize(SizeInfo categorySize) {
    categorySizeRepository.saveOrUpdate(categorySize);
    return categorySize.getId();
  }

  public boolean saveSizeList(List<SizeInfo> sizeInfoList) {
    return categorySizeRepository.saveBatch(sizeInfoList);
  }

  /**
   * 保存/更新对象中的非空值
   *
   * @param categorySize 待处理对象
   * @return Long 主键
   */
  @Transactional
  public Long saveCategorySizeNotNull(SizeInfo categorySize) {
    categorySizeRepository.saveOrUpdatePatch(categorySize);
    return categorySize.getId();
  }

  /**
   * 根据主键查询对象
   *
   * @param id 主键
   * @return CategorySize 对象实体
   */
  public SizeInfo getCategorySizeById(Long id) {
    return categorySizeRepository.getById(id);
  }

  /**
   * 根据条件查询分页集合
   *
   * @param categorySize 实体参宿对象
   * @return IPage<CategorySize> 分页对象
   */
  public IPage<SizeInfo> pageByCategorySize(SizeInfo categorySize) {
    return categorySizeRepository.pageByCategorySize(categorySize);
  }

  /**
   * 查询所有数据
   *
   * @return List<CategorySize> 数据结果集合
   */
  public List<SizeInfo> queryCategorySize() {
    return categorySizeRepository.list(null);
  }

  /**
   * 根据id删除对象
   *
   * @param id 主键id
   * @return 是否删除成功 true：成功，false：失败
   */
  public Boolean deleteCategorySizeById(Long id) {
    return categorySizeRepository.removeById(id);
  }
}
