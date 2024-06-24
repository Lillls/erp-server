package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.Resource;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 后端访问资源 Resource数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class ResourceRepository extends BaseRepository<ResourceMapper, Resource> {

    /**
     * 查询分页对象
     * @param resource 条件查询对象
     * @return IPage<Resource>
     */
    public IPage<Resource> pageByResource(Resource resource) {
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(resource);
        return pageAndSort(queryWrapper, resource);
    }
}
