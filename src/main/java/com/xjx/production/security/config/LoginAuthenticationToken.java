package com.xjx.production.security.config;

import com.xjx.production.dto.user.MenuDto;
import com.xjx.production.entity.sys.Menu;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * 替补  回头看看能不能用上
 */
public class LoginAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final List<MenuDto> menuList;

    public LoginAuthenticationToken(Object principal, Object credentials, List<MenuDto> menuList) {
        super(principal, credentials);
        this.menuList = menuList;
    }

    public LoginAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, List<MenuDto> menuList) {
        super(principal, credentials, authorities);
        this.menuList = menuList;
    }

    public List<MenuDto> getMenuList() {
        return menuList;
    }
}
