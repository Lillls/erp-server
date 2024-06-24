package com.xjx.production.service.sys;

import com.xjx.production.entity.sys.Resource;
import com.xjx.production.repository.sys.ResourceMapper;
import com.xjx.production.repository.sys.ResourceRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 后端访问资源 Resource业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class ResourceService {

    /**
     * resourceMapper
     */
    @Autowired
    ResourceMapper resourceMapper;

    /**
     * resourceRepository
     */
    @Autowired
    ResourceRepository resourceRepository;

    /**
     * 保存/更新对象
     * @param resource 待处理对象
     * @return Long 主键
     */
    public Long saveResource(Resource resource){
        resourceRepository.saveOrUpdate(resource);
        return resource.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param resource 待处理对象
     * @return Long 主键
     */
    public Long saveResourceNotNull(Resource resource){
        resourceRepository.saveOrUpdatePatch(resource);
        return resource.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return Resource 对象实体
     */
    public Resource getResourceById(Long id) {
        return resourceRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param resource 实体参宿对象
     * @return IPage<Resource> 分页对象
     */
    public IPage<Resource> pageByResource(Resource resource) {
        return resourceRepository.pageByResource(resource);
    }

    /**
     * 查询所有数据
     * @return List<Resource> 数据结果集合
     */
    public List<Resource> queryResource() {
        return resourceRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteResourceById(Long id) {
        return resourceRepository.removeById(id);
    }
}
