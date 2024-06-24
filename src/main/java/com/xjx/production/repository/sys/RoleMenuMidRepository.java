package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.RoleMenuMid;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 角色与菜单关联表 RoleMenuMid数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class RoleMenuMidRepository extends BaseRepository<RoleMenuMidMapper, RoleMenuMid> {

    /**
     * 查询分页对象
     * @param roleMenuMid 条件查询对象
     * @return IPage<RoleMenuMid>
     */
    public IPage<RoleMenuMid> pageByRoleMenuMid(RoleMenuMid roleMenuMid) {
        QueryWrapper<RoleMenuMid> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(roleMenuMid);
        return pageAndSort(queryWrapper, roleMenuMid);
    }
}
