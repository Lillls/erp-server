package com.xjx.production.controller.sys;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.RoleService;
import com.xjx.production.entity.sys.Role;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.production.base.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 * 角色表 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    /**
     * role业务处理类
     */
    @Autowired
    RoleService roleService;

    @ApiOperation(value = "新增/更新Role", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "role", value = "待保存的Role", required = true, dataTypeClass = Role.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody Role role) {
        return R.ok(roleService.saveRole(role));
    }

    @ApiOperation(value = "新增/更新非空字段Role", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "role", value = "待保存的Role", required = true, dataTypeClass = Role.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody Role role) {
        return R.ok(roleService.saveRoleNotNull(role));
    }

    @ApiOperation(value = "根据id返回Role")
    @ApiImplicitParam(name = "id", value = "Role的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<Role> get(@PathVariable(name = "id") Long id) { return R.ok(roleService.getRoleById(id));}

    @ApiOperation(value = "根据对象返回带分页的Role")
    @ApiImplicitParam(name = "role", value = "待查询的Role", required = true, dataTypeClass = Role.class, paramType = "body")
    @PostMapping()
    public R<IPage<Role>> page(@RequestBody Role role) {
        return R.ok(roleService.pageByRole(role));
    }

    @ApiOperation(value = "删除Role", notes = "根据主键id删除Role ")
    @ApiImplicitParam(name = "id", value = "Role的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(roleService.deleteRoleById(id));
    }

}
