package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.UserRoleMid;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用户与角色关联表 UserRoleMid数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class UserRoleMidRepository extends BaseRepository<UserRoleMidMapper, UserRoleMid> {

    /**
     * 查询分页对象
     * @param userRoleMid 条件查询对象
     * @return IPage<UserRoleMid>
     */
    public IPage<UserRoleMid> pageByUserRoleMid(UserRoleMid userRoleMid) {
        QueryWrapper<UserRoleMid> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userRoleMid);
        return pageAndSort(queryWrapper, userRoleMid);
    }
}
