package com.xjx.production.plugin;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by tw on 2022/6/15.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);

        this.setFieldValByName("creatorName", "未登录用户", metaObject);
        this.setFieldValByName("creator", 0L, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);

        this.setFieldValByName("updatorName", "未登录用户", metaObject);
        this.setFieldValByName("updator", 0L, metaObject);
    }
}
