package com.xjx.production.service.product;

import com.xjx.production.entity.product.LxyShop;
import com.xjx.production.repository.product.LxyShopMapper;
import com.xjx.production.repository.product.LxyShopRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 *  LxyShop业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-05-08
 */
@Service
public class LxyShopService {

    /**
     * lxyShopMapper
     */
    @Autowired
    LxyShopMapper lxyShopMapper;

    /**
     * lxyShopRepository
     */
    @Autowired
    LxyShopRepository lxyShopRepository;

    /**
     * 保存/更新对象
     * @param lxyShop 待处理对象
     * @return Long 主键
     */
    public Long saveLxyShop(LxyShop lxyShop){
        lxyShopRepository.saveOrUpdate(lxyShop);
        return lxyShop.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param lxyShop 待处理对象
     * @return Long 主键
     */
    public Long saveLxyShopNotNull(LxyShop lxyShop){
        lxyShopRepository.saveOrUpdatePatch(lxyShop);
        return lxyShop.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return LxyShop 对象实体
     */
    public LxyShop getLxyShopById(Long id) {
        return lxyShopRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param lxyShop 实体参宿对象
     * @return IPage<LxyShop> 分页对象
     */
    public IPage<LxyShop> pageByLxyShop(LxyShop lxyShop) {
        return lxyShopRepository.pageByLxyShop(lxyShop);
    }

    /**
     * 查询所有数据
     * @return List<LxyShop> 数据结果集合
     */
    public List<LxyShop> queryLxyShop() {
        return lxyShopRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteLxyShopById(Long id) {
        return lxyShopRepository.removeById(id);
    }
}
