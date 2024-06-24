package com.xjx.production.security.permission;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class DynamicConfigAttribute extends SecurityConfig {

    public DynamicConfigAttribute(String config) {
        super(config);
    }

    public static List<ConfigAttribute> createList(List<String> roleNames) {
        Assert.notNull(roleNames, "角色名称集合不能为空!");
        List<ConfigAttribute> attributes = new ArrayList(roleNames.size());
        roleNames.forEach(item -> attributes.add(new DynamicConfigAttribute(item)));
        return attributes;
    }
}
