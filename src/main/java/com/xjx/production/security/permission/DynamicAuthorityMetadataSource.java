package com.xjx.production.security.permission;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.tools.packager.Log;
import com.xjx.production.entity.sys.Role;
import com.xjx.production.repository.sys.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
@Slf4j
public class DynamicAuthorityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest httpRequest = ((FilterInvocation) object).getHttpRequest();
        String method = httpRequest.getMethod();
        String urlPattern = httpRequest.getRequestURI();
        try {
            requestMappingHandlerMapping.getHandler( httpRequest);
            urlPattern = Objects.nonNull(httpRequest.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE)) ?
                    (String) httpRequest.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE) : urlPattern;
            log.info("本次请求url—pattern:{},请求方式:{}，开始查询拥有该资源的角色", urlPattern, method);
            List<String> roleNames = roleMapper.queryRoleNameByPattern(urlPattern, method);
            if(!CollectionUtils.isEmpty(roleNames)){
                if(Log.isDebug()){
                    log.debug("本次请求url—pattern:{},请求方式:{},需要角色:{}", urlPattern, method, roleNames);
                }
                return DynamicConfigAttribute.createList(roleNames);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("本次请求url—pattern:{},请求方式:{},没配置相关角色,为了方便调试暂时直接放行!", urlPattern, method);

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public static void main(String[] args) {
    }
}
