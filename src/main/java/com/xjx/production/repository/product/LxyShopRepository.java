package com.xjx.production.repository.product;

import com.xjx.production.entity.product.LxyShop;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  LxyShop数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@Service
public class LxyShopRepository extends BaseRepository<LxyShopMapper, LxyShop> {

    /**
     * 查询分页对象
     * @param lxyShop 条件查询对象
     * @return IPage<LxyShop>
     */
    public IPage<LxyShop> pageByLxyShop(LxyShop lxyShop) {
        QueryWrapper<LxyShop> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(lxyShop);
        return pageAndSort(queryWrapper, lxyShop);
    }
}
