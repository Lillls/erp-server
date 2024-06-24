package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.Menu;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 菜单表 Menu数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class MenuRepository extends BaseRepository<MenuMapper, Menu> {

    /**
     * 查询分页对象
     * @param menu 条件查询对象
     * @return IPage<Menu>
     */
    public IPage<Menu> pageByMenu(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(menu);
        return pageAndSort(queryWrapper, menu);
    }
}
