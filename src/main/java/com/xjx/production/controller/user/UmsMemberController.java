package com.xjx.production.controller.user;


import com.xjx.production.base.R;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.user.UmsMemberService;
import com.xjx.production.entity.user.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 *  Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-05-10
 */
@RestController
@RequestMapping("/umsMember")
public class UmsMemberController {
    /**
     * umsMember业务处理类
     */
    @Autowired
    UmsMemberService umsMemberService;

    @ApiOperation(value = "新增/更新UmsMember", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "umsMember", value = "待保存的UmsMember", required = true, dataTypeClass = UmsMember.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody UmsMember umsMember) {
        return R.ok(umsMemberService.saveUmsMember(umsMember));
    }

    @ApiOperation(value = "新增/更新非空字段UmsMember", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "umsMember", value = "待保存的UmsMember", required = true, dataTypeClass = UmsMember.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody UmsMember umsMember) {
        return R.ok(umsMemberService.saveUmsMemberNotNull(umsMember));
    }

    @ApiOperation(value = "根据id返回UmsMember")
    @ApiImplicitParam(name = "id", value = "UmsMember的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<UmsMember> get(@PathVariable(name = "id") Long id) { return R.ok(umsMemberService.getUmsMemberById(id));}

    @ApiOperation(value = "根据对象返回带分页的UmsMember")
    @ApiImplicitParam(name = "umsMember", value = "待查询的UmsMember", required = true, dataTypeClass = UmsMember.class, paramType = "body")
    @PostMapping()
    public R<IPage<UmsMember>> page(@RequestBody UmsMember umsMember) {
        return R.ok(umsMemberService.pageByUmsMember(umsMember));
    }

    @ApiOperation(value = "删除UmsMember", notes = "根据主键id删除UmsMember ")
    @ApiImplicitParam(name = "id", value = "UmsMember的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(umsMemberService.deleteUmsMemberById(id));
    }

    @ApiOperation(value = "获取当前登录用户", notes = "获取当前登录用户")
    @GetMapping("/getCurrentUser")
    public R<Authentication> getCurrentUser() {
        return R.ok(SecurityContextHolder.getContext().getAuthentication());
    }

}
