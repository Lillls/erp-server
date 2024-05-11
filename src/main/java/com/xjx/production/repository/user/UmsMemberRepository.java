package com.xjx.production.repository.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.plugin.BaseRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Date;

/**
 * <p>
 *  UmsMember数据库操作类
 * </p>
 *
 * @author xjx
 * @since 2024-05-10
 */
@Service
public class UmsMemberRepository extends BaseRepository<UmsMemberMapper, UmsMember> {

    /**
     * 查询分页对象
     * @param umsMember 条件查询对象
     * @return IPage<UmsMember>
     */
    public IPage<UmsMember> pageByUmsMember(UmsMember umsMember) {
        QueryWrapper<UmsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(umsMember);
        return pageAndSort(queryWrapper, umsMember);
    }

    /**
     * 根据用户名 查询用户
     */
    public UmsMember queryMemberByUserName(String userName){
        LambdaQueryWrapper<UmsMember> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsMember::getUserName, userName);
        return getOne(wrapper);
    }

    /**
     * 把jwt写进数据库
     * @param id
     * @param jwt
     * @return
     */
    public Boolean updateToken(Long id, String jwt){
        LambdaUpdateWrapper<UmsMember> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(UmsMember::getToken, jwt)
                .set(UmsMember::getUpdateTime, new Date())
                .eq(UmsMember::getId, id);
        return update(wrapper);
    }
}
