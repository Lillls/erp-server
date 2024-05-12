package com.xjx.production.service.product;

import com.xjx.production.entity.product.Shop;
import com.xjx.production.repository.product.ShopMapper;
import com.xjx.production.repository.product.ShopRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 *  Shop业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@Service
public class ShopService {

    /**
     * ShopMapper
     */
    @Autowired
    ShopMapper mShopMapper;

    /**
     * ShopRepository
     */
    @Autowired
    ShopRepository mShopRepository;

    /**
     * 保存/更新对象
     * @param shop 待处理对象
     * @return Long 主键
     */
    public Long saveShop(Shop shop){
        mShopRepository.saveOrUpdate(shop);
        return shop.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param shop 待处理对象
     * @return Long 主键
     */
    public Long saveShopNotNull(Shop shop){
        mShopRepository.saveOrUpdatePatch(shop);
        return shop.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return Shop 对象实体
     */
    public Shop getShopById(Long id) {
        return mShopRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param shop 实体参宿对象
     * @return IPage<Shop> 分页对象
     */
    public IPage<Shop> pageByShop(Shop shop) {
        return mShopRepository.pageByShop(shop);
    }

    /**
     * 查询所有数据
     * @return List<Shop> 数据结果集合
     */
    public List<Shop> queryShop() {
        return mShopRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteShopById(Long id) {
        return mShopRepository.removeById(id);
    }
}
