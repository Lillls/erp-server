package com.xjx.production.repository.sys;

import com.xjx.production.dto.user.MenuDto;
import com.xjx.production.entity.sys.Menu;
import com.xjx.production.plugin.MyBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Component
public interface MenuMapper extends MyBaseMapper<Menu> {

    List<MenuDto> loginMenuList(@Param("userId")Long userId, @Param("parentId")Long parentId);

}
