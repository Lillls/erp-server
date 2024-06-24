package com.xjx.production.controller.sys;


import com.xjx.production.base.R;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.UserRoleMidService;
import com.xjx.production.entity.sys.UserRoleMid;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户与角色关联表 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/userRoleMid")
public class UserRoleMidController {
    /**
     * userRoleMid业务处理类
     */
    @Autowired
    UserRoleMidService userRoleMidService;

    @ApiOperation(value = "新增/更新UserRoleMid", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "userRoleMid", value = "待保存的UserRoleMid", required = true, dataTypeClass = UserRoleMid.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody UserRoleMid userRoleMid) {
        return R.ok(userRoleMidService.saveUserRoleMid(userRoleMid));
    }

    @ApiOperation(value = "新增/更新非空字段UserRoleMid", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "userRoleMid", value = "待保存的UserRoleMid", required = true, dataTypeClass = UserRoleMid.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody UserRoleMid userRoleMid) {
        return R.ok(userRoleMidService.saveUserRoleMidNotNull(userRoleMid));
    }

    @ApiOperation(value = "根据id返回UserRoleMid")
    @ApiImplicitParam(name = "id", value = "UserRoleMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<UserRoleMid> get(@PathVariable(name = "id") Long id) { return R.ok(userRoleMidService.getUserRoleMidById(id));}

    @ApiOperation(value = "根据对象返回带分页的UserRoleMid")
    @ApiImplicitParam(name = "userRoleMid", value = "待查询的UserRoleMid", required = true, dataTypeClass = UserRoleMid.class, paramType = "body")
    @PostMapping()
    public R<IPage<UserRoleMid>> page(@RequestBody UserRoleMid userRoleMid) {
        return R.ok(userRoleMidService.pageByUserRoleMid(userRoleMid));
    }

    @ApiOperation(value = "删除UserRoleMid", notes = "根据主键id删除UserRoleMid ")
    @ApiImplicitParam(name = "id", value = "UserRoleMid的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(userRoleMidService.deleteUserRoleMidById(id));
    }

}
