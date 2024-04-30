package com.xjx.production.service.category;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjx.production.dto.category.CategoryPageResult;
import com.xjx.production.entity.category.Category;
import com.xjx.production.repository.category.CategoryMapper;
import com.xjx.production.repository.category.CategoryRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  Category业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class CategoryService {

    /**
     * categoryMapper
     */
    @Autowired
    CategoryMapper categoryMapper;

    /**
     * categoryRepository
     */
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * 保存/更新对象
     * @param category 待处理对象
     * @return Long 主键
     */
    @Transactional
    public Long saveCategory(Category category){
        categoryRepository.saveOrUpdate(category);
        return category.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param category 待处理对象
     * @return Long 主键
     */
    @Transactional
    public Long saveCategoryNotNull(Category category){
        categoryRepository.saveOrUpdatePatch(category);
        return category.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return Category 对象实体
     */
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param category 实体参宿对象
     * @return IPage<Category> 分页对象
     */
    public IPage<CategoryPageResult> pageByCategory(Category category) {
        Page<CategoryPageResult> page = new Page<>(category.getCurrent(), category.getSize());
        page.setOptimizeCountSql(false);
        return categoryMapper.pageByParam(page, category);
    }

    /**
     * 查询所有数据
     * @return List<Category> 数据结果集合
     */
    public List<Category> queryCategory() {
        return categoryRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteCategoryById(Long id) {
        return categoryRepository.removeById(id);
    }
}
