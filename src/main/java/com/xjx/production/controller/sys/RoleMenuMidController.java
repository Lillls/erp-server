package com.xjx.production.controller.sys;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.RoleMenuMidService;
import com.xjx.production.entity.sys.RoleMenuMid;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.production.base.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 * 角色与菜单关联表 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/roleMenuMid")
public class RoleMenuMidController {
    /**
     * roleMenuMid业务处理类
     */
    @Autowired
    RoleMenuMidService roleMenuMidService;

    @ApiOperation(value = "新增/更新RoleMenuMid", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "roleMenuMid", value = "待保存的RoleMenuMid", required = true, dataTypeClass = RoleMenuMid.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody RoleMenuMid roleMenuMid) {
        return R.ok(roleMenuMidService.saveRoleMenuMid(roleMenuMid));
    }

    @ApiOperation(value = "新增/更新非空字段RoleMenuMid", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "roleMenuMid", value = "待保存的RoleMenuMid", required = true, dataTypeClass = RoleMenuMid.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody RoleMenuMid roleMenuMid) {
        return R.ok(roleMenuMidService.saveRoleMenuMidNotNull(roleMenuMid));
    }

    @ApiOperation(value = "根据id返回RoleMenuMid")
    @ApiImplicitParam(name = "id", value = "RoleMenuMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<RoleMenuMid> get(@PathVariable(name = "id") Long id) { return R.ok(roleMenuMidService.getRoleMenuMidById(id));}

    @ApiOperation(value = "根据对象返回带分页的RoleMenuMid")
    @ApiImplicitParam(name = "roleMenuMid", value = "待查询的RoleMenuMid", required = true, dataTypeClass = RoleMenuMid.class, paramType = "body")
    @PostMapping()
    public R<IPage<RoleMenuMid>> page(@RequestBody RoleMenuMid roleMenuMid) {
        return R.ok(roleMenuMidService.pageByRoleMenuMid(roleMenuMid));
    }

    @ApiOperation(value = "删除RoleMenuMid", notes = "根据主键id删除RoleMenuMid ")
    @ApiImplicitParam(name = "id", value = "RoleMenuMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(roleMenuMidService.deleteRoleMenuMidById(id));
    }

}
