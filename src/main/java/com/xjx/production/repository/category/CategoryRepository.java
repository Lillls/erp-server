package com.xjx.production.repository.category;

import com.xjx.production.entity.category.Category;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  Category数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class CategoryRepository extends BaseRepository<CategoryMapper, Category> {

    /**
     * 查询分页对象
     * @param category 条件查询对象
     * @return IPage<Category>
     */
    public IPage<Category> pageByCategory(Category category) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(category);
        return pageAndSort(queryWrapper, category);
    }
}
