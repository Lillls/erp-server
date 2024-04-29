package com.xjx.production.plugin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xjx
 * @since 2022-05-09
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    int insertBatchSomeColumn(List<T> entityList);

    boolean alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

    int deleteByIdWithFill(T entity);

}
