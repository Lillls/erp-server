package com.xjx.production.service.sys;

import com.xjx.production.entity.sys.Role;
import com.xjx.production.repository.sys.RoleMapper;
import com.xjx.production.repository.sys.RoleRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 角色表 Role业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Service
public class RoleService {

    /**
     * roleMapper
     */
    @Autowired
    RoleMapper roleMapper;

    /**
     * roleRepository
     */
    @Autowired
    RoleRepository roleRepository;

    /**
     * 保存/更新对象
     * @param role 待处理对象
     * @return Long 主键
     */
    public Long saveRole(Role role){
        roleRepository.saveOrUpdate(role);
        return role.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param role 待处理对象
     * @return Long 主键
     */
    public Long saveRoleNotNull(Role role){
        roleRepository.saveOrUpdatePatch(role);
        return role.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return Role 对象实体
     */
    public Role getRoleById(Long id) {
        return roleRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param role 实体参宿对象
     * @return IPage<Role> 分页对象
     */
    public IPage<Role> pageByRole(Role role) {
        return roleRepository.pageByRole(role);
    }

    /**
     * 查询所有数据
     * @return List<Role> 数据结果集合
     */
    public List<Role> queryRole() {
        return roleRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteRoleById(Long id) {
        return roleRepository.removeById(id);
    }
}
