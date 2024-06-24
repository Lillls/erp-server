package com.xjx.production.repository.sys;

import com.xjx.production.entity.sys.Role;
import com.xjx.production.plugin.MyBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@Component
public interface RoleMapper extends MyBaseMapper<Role> {

    List<String> queryRoleNameByPattern(@Param("pattern")String pattern, @Param("method")String method);

    List<String> queryRoleList(@Param("userId")Long userId);

}
