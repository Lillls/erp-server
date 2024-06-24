package com.xjx.production.service.sys;

import com.xjx.production.entity.sys.UserRoleMid;
import com.xjx.production.repository.sys.UserRoleMidMapper;
import com.xjx.production.repository.sys.UserRoleMidRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 用户与角色关联表 UserRoleMid业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class UserRoleMidService {

    /**
     * userRoleMidMapper
     */
    @Autowired
    UserRoleMidMapper userRoleMidMapper;

    /**
     * userRoleMidRepository
     */
    @Autowired
    UserRoleMidRepository userRoleMidRepository;

    /**
     * 保存/更新对象
     * @param userRoleMid 待处理对象
     * @return Long 主键
     */
    public Long saveUserRoleMid(UserRoleMid userRoleMid){
        userRoleMidRepository.saveOrUpdate(userRoleMid);
        return userRoleMid.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param userRoleMid 待处理对象
     * @return Long 主键
     */
    public Long saveUserRoleMidNotNull(UserRoleMid userRoleMid){
        userRoleMidRepository.saveOrUpdatePatch(userRoleMid);
        return userRoleMid.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return UserRoleMid 对象实体
     */
    public UserRoleMid getUserRoleMidById(Long id) {
        return userRoleMidRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param userRoleMid 实体参宿对象
     * @return IPage<UserRoleMid> 分页对象
     */
    public IPage<UserRoleMid> pageByUserRoleMid(UserRoleMid userRoleMid) {
        return userRoleMidRepository.pageByUserRoleMid(userRoleMid);
    }

    /**
     * 查询所有数据
     * @return List<UserRoleMid> 数据结果集合
     */
    public List<UserRoleMid> queryUserRoleMid() {
        return userRoleMidRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteUserRoleMidById(Long id) {
        return userRoleMidRepository.removeById(id);
    }
}
