package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.MenuResourceMid;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 菜单与资源关联表 MenuResourceMid数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class MenuResourceMidRepository extends BaseRepository<MenuResourceMidMapper, MenuResourceMid> {

    /**
     * 查询分页对象
     * @param menuResourceMid 条件查询对象
     * @return IPage<MenuResourceMid>
     */
    public IPage<MenuResourceMid> pageByMenuResourceMid(MenuResourceMid menuResourceMid) {
        QueryWrapper<MenuResourceMid> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(menuResourceMid);
        return pageAndSort(queryWrapper, menuResourceMid);
    }
}
