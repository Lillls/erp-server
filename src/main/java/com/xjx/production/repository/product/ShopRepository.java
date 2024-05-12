package com.xjx.production.repository.product;

import com.xjx.production.entity.product.Shop;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  Shop数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@Service
public class ShopRepository extends BaseRepository<ShopMapper, Shop> {

    /**
     * 查询分页对象
     * @param shop 条件查询对象
     * @return IPage<Shop>
     */
    public IPage<Shop> pageByShop(Shop shop) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(shop);
        return pageAndSort(queryWrapper, shop);
    }
}
