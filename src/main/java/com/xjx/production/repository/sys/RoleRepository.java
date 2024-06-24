package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.Role;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 角色表 Role数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class RoleRepository extends BaseRepository<RoleMapper, Role> {

    /**
     * 查询分页对象
     * @param role 条件查询对象
     * @return IPage<Role>
     */
    public IPage<Role> pageByRole(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(role);
        return pageAndSort(queryWrapper, role);
    }
}
