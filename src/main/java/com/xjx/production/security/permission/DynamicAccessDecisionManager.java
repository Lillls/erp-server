package com.xjx.production.security.permission;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@Component
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(CollectionUtils.isEmpty(authorities)){
            throw new AccessDeniedException("用户没有配置任何角色，无权访问系统!");
        }

        for (ConfigAttribute configAttribute : configAttributes) {
            for (GrantedAuthority authority : authorities) {
                if(configAttribute.getAttribute().equalsIgnoreCase(authority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("自定义没有权限访问!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
