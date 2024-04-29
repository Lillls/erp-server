package com.xjx.production.plugin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseRepository<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> {
    /**
     * saveOrUpdate 只更新非空字段
     * @param entity
     * @return
     */
    public boolean saveOrUpdatePatch(T entity) {
        return super.saveOrUpdate(entity);
    }

    /**
     * saveOrUpdate 根据queryWrapper只更新非空字段
     * @param entity
     * @return
     */
    public boolean saveOrUpdatePatch(T entity, UpdateWrapper<T> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }

    /**
     * 重写saveOrUpdate 根据条件更新全部字段
     * @param entity
     * @return
     */
    public boolean saveOrUpdate(T entity, UpdateWrapper<T> updateWrapper) {
        return this.update(entity, updateWrapper) || this.saveOrUpdate(entity);
    }

    /**
     * 重写saveOrUpdate 更新全部字段
     * @param entity
     * @return
     */
    @Override
    public boolean saveOrUpdate(T entity) {
        if (null == entity) {
            return false;
        } else {
            Class<?> cls = entity.getClass();
            TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
            Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
            String keyProperty = tableInfo.getKeyProperty();
            Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
            Object idVal = ReflectionKit.getFieldValue(entity,tableInfo.getKeyProperty());
            return !StringUtils.checkValNull(idVal) && !Objects.isNull(this.getById((Serializable)idVal)) ? this.updateAllColumnById(entity) : this.save(entity);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateAllColumnById(T entity) {
        return baseMapper.alwaysUpdateSomeColumnById(entity);
    }

    public IPage<T> pageAndSort(QueryWrapper<T> queryWrapper, AbstractBaseEntity t) {
        if(t == null){
            return null;
        }
        Page<T> page = new Page<>(t.getCurrent(), t.getSize());
//        setSort(page, t.getSort());
        setSort(t.getSort(),queryWrapper);
        return page(page, queryWrapper);
    }

    public IPage<T> pageAndSort(LambdaQueryWrapper<T> lambdaQueryWrapper, AbstractBaseEntity t) {
        if(t == null){
            return null;
        }
        Page<T> page = new Page<>(t.getCurrent(), t.getSize());
        setSort(page, t.getSort());
        return page(page, lambdaQueryWrapper);
    }

    public void setSort(QueryWrapper<T> queryWrapper, AbstractBaseEntity t) {
        if(t != null && t.getSort() != null && ((t.getSort().contains("asc") || t.getSort().contains("desc")) && t.getSort().contains("&"))) {
            queryWrapper.last(t.getSort().replace("&", " "));
        }
    }

    private void setSort(Page<T> page, String sort){
        if(sort != null && ((sort.contains("asc") || sort.contains("desc")) && sort.contains("&"))){
            List<OrderItem> orderItemList = new ArrayList<>();
            String[] sortItems = sort.split(",");
            for(String sortItem : sortItems){
                OrderItem orderItem = new OrderItem();
                String[] items = sortItem.split("&");
                orderItem.setColumn(items[0]);
                boolean asc = true;
                if(!items[1].equals("asc")){
                    asc = false;
                }
                orderItem.setAsc(asc);
                orderItemList.add(orderItem);
            }
            page.addOrder(orderItemList);
        }
    }

    private void setSort(String sort,QueryWrapper<T> queryWrapper){
        if(sort != null && ((sort.contains("asc") || sort.contains("desc")) && sort.contains("&"))){
            String[] sortItems = sort.split(",");
            List<String> lstDesc = new ArrayList<>();
            List<String> lstAsc = new ArrayList<>();
            for(String sortItem : sortItems){
                OrderItem orderItem = new OrderItem();
                String[] items = sortItem.split("&");
                if(!items[1].equals("asc")){
                    lstDesc.add(items[0]);
                }else{
                    lstAsc.add(items[0]);
                }
            }
            queryWrapper.orderByDesc(lstDesc);
            queryWrapper.orderByAsc(lstAsc);
        }
    }

}
