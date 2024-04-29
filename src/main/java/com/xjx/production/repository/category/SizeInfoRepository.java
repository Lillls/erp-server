package com.xjx.production.repository.category;

import com.xjx.production.entity.category.SizeInfo;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  CategorySize数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-04-17
 */
@Service
public class SizeInfoRepository extends BaseRepository<SizeInfoMapper, SizeInfo> {

    /**
     * 查询分页对象
     * @param categorySize 条件查询对象
     * @return IPage<CategorySize>
     */
    public IPage<SizeInfo> pageByCategorySize(SizeInfo categorySize) {
        QueryWrapper<SizeInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(categorySize);
        return pageAndSort(queryWrapper, categorySize);
    }
}
