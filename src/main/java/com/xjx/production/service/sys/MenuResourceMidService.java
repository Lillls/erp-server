package com.xjx.production.service.sys;

import com.xjx.production.entity.sys.MenuResourceMid;
import com.xjx.production.repository.sys.MenuResourceMidMapper;
import com.xjx.production.repository.sys.MenuResourceMidRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 菜单与资源关联表 MenuResourceMid业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class MenuResourceMidService {

    /**
     * menuResourceMidMapper
     */
    @Autowired
    MenuResourceMidMapper menuResourceMidMapper;

    /**
     * menuResourceMidRepository
     */
    @Autowired
    MenuResourceMidRepository menuResourceMidRepository;

    /**
     * 保存/更新对象
     * @param menuResourceMid 待处理对象
     * @return Long 主键
     */
    public Long saveMenuResourceMid(MenuResourceMid menuResourceMid){
        menuResourceMidRepository.saveOrUpdate(menuResourceMid);
        return menuResourceMid.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param menuResourceMid 待处理对象
     * @return Long 主键
     */
    public Long saveMenuResourceMidNotNull(MenuResourceMid menuResourceMid){
        menuResourceMidRepository.saveOrUpdatePatch(menuResourceMid);
        return menuResourceMid.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return MenuResourceMid 对象实体
     */
    public MenuResourceMid getMenuResourceMidById(Long id) {
        return menuResourceMidRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param menuResourceMid 实体参宿对象
     * @return IPage<MenuResourceMid> 分页对象
     */
    public IPage<MenuResourceMid> pageByMenuResourceMid(MenuResourceMid menuResourceMid) {
        return menuResourceMidRepository.pageByMenuResourceMid(menuResourceMid);
    }

    /**
     * 查询所有数据
     * @return List<MenuResourceMid> 数据结果集合
     */
    public List<MenuResourceMid> queryMenuResourceMid() {
        return menuResourceMidRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteMenuResourceMidById(Long id) {
        return menuResourceMidRepository.removeById(id);
    }
}
