package com.xjx.production.service.sys;

import com.erp.auth.authentication.dto.MenuDto;
import com.erp.auth.inter.AuthMenuService;
import com.xjx.production.entity.sys.Menu;
import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.repository.sys.MenuMapper;
import com.xjx.production.repository.sys.MenuRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p>
 * 菜单表 Menu业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class MenuService implements AuthMenuService {

    /**
     * menuMapper
     */
    @Autowired
    MenuMapper menuMapper;

    /**
     * menuRepository
     */
    @Autowired
    MenuRepository menuRepository;

    /**
     * 保存/更新对象
     * @param menu 待处理对象
     * @return Long 主键
     */
    public Long saveMenu(Menu menu){
        menuRepository.saveOrUpdate(menu);
        return menu.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param menu 待处理对象
     * @return Long 主键
     */
    public Long saveMenuNotNull(Menu menu){
        menuRepository.saveOrUpdatePatch(menu);
        return menu.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return Menu 对象实体
     */
    public Menu getMenuById(Long id) {
        return menuRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param menu 实体参宿对象
     * @return IPage<Menu> 分页对象
     */
    public IPage<Menu> pageByMenu(Menu menu) {
        return menuRepository.pageByMenu(menu);
    }

    /**
     * 查询所有数据
     * @return List<Menu> 数据结果集合
     */
    public List<Menu> queryMenu() {
        return menuRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteMenuById(Long id) {
        return menuRepository.removeById(id);
    }


    /**
     * 登录后获取菜单数据
     * @param userId
     * @param parentId
     * @return
     */
    public List<MenuDto> getMenuWithChild(Long userId, Long parentId){
        if(Objects.isNull(userId)){
            UmsMember umsMember = (UmsMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userId = umsMember.getId();
        }
        List<MenuDto> menuDtos = menuMapper.loginMenuList(userId, parentId);
        if(CollectionUtils.isEmpty(menuDtos)){
            return new ArrayList<>();
        }

        for (MenuDto menuDto : menuDtos) {
            menuDto.setChildMenu(this.getMenuWithChild(userId, menuDto.getId()));
        }
        return menuDtos;
    }

    @Override
    public List<MenuDto> queryMenusByUserId(Long userId) {
        return getMenuWithChild(userId, 0L);
    }
}
