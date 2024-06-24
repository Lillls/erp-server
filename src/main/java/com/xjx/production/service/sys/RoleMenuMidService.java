package com.xjx.production.service.sys;

import com.xjx.production.entity.sys.RoleMenuMid;
import com.xjx.production.repository.sys.RoleMenuMidMapper;
import com.xjx.production.repository.sys.RoleMenuMidRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 角色与菜单关联表 RoleMenuMid业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class RoleMenuMidService {

    /**
     * roleMenuMidMapper
     */
    @Autowired
    RoleMenuMidMapper roleMenuMidMapper;

    /**
     * roleMenuMidRepository
     */
    @Autowired
    RoleMenuMidRepository roleMenuMidRepository;

    /**
     * 保存/更新对象
     * @param roleMenuMid 待处理对象
     * @return Long 主键
     */
    public Long saveRoleMenuMid(RoleMenuMid roleMenuMid){
        roleMenuMidRepository.saveOrUpdate(roleMenuMid);
        return roleMenuMid.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param roleMenuMid 待处理对象
     * @return Long 主键
     */
    public Long saveRoleMenuMidNotNull(RoleMenuMid roleMenuMid){
        roleMenuMidRepository.saveOrUpdatePatch(roleMenuMid);
        return roleMenuMid.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return RoleMenuMid 对象实体
     */
    public RoleMenuMid getRoleMenuMidById(Long id) {
        return roleMenuMidRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param roleMenuMid 实体参宿对象
     * @return IPage<RoleMenuMid> 分页对象
     */
    public IPage<RoleMenuMid> pageByRoleMenuMid(RoleMenuMid roleMenuMid) {
        return roleMenuMidRepository.pageByRoleMenuMid(roleMenuMid);
    }

    /**
     * 查询所有数据
     * @return List<RoleMenuMid> 数据结果集合
     */
    public List<RoleMenuMid> queryRoleMenuMid() {
        return roleMenuMidRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteRoleMenuMidById(Long id) {
        return roleMenuMidRepository.removeById(id);
    }
}
