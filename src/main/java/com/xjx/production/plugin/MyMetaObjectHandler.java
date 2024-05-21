package com.xjx.production.plugin;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.xjx.production.entity.user.UmsMember;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * Created by tw on 2022/6/15.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UmsMember umsMember = (UmsMember)authentication.getPrincipal();

        if(Objects.nonNull(umsMember)){
            this.setFieldValByName("creatorName", umsMember.getUserName(), metaObject);
            this.setFieldValByName("creator", umsMember.getId(), metaObject);
        }


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UmsMember umsMember = (UmsMember)authentication.getPrincipal();

        if(Objects.nonNull(umsMember)){
            this.setFieldValByName("updatorName", umsMember.getUserName(), metaObject);
            this.setFieldValByName("updator", umsMember.getId(), metaObject);
        }

    }
}
