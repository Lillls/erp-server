package com.xjx.production.repository.basic;

import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  ForbiddenWord数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-05-18
 */
@Service
public class ForbiddenWordRepository extends BaseRepository<ForbiddenWordMapper, ForbiddenWord> {

    /**
     * 查询分页对象
     * @param forbiddenWord 条件查询对象
     * @return IPage<ForbiddenWord>
     */
    public IPage<ForbiddenWord> pageByForbiddenWord(ForbiddenWord forbiddenWord) {
        QueryWrapper<ForbiddenWord> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(forbiddenWord);
        return pageAndSort(queryWrapper, forbiddenWord);
    }
}
