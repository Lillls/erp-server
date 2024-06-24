package com.xjx.production.controller.sys;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.sys.ResourceService;
import com.xjx.production.entity.sys.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.production.base.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * <p>
 * 后端访问资源 Restful api
 * </p>
 *
 * @author xjx
 * @since 2024-06-24
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    /**
     * resource业务处理类
     */
    @Autowired
    ResourceService resourceService;

    @ApiOperation(value = "新增/更新Resource", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "resource", value = "待保存的Resource", required = true, dataTypeClass = Resource.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody Resource resource) {
        return R.ok(resourceService.saveResource(resource));
    }

    @ApiOperation(value = "新增/更新非空字段Resource", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "resource", value = "待保存的Resource", required = true, dataTypeClass = Resource.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody Resource resource) {
        return R.ok(resourceService.saveResourceNotNull(resource));
    }

    @ApiOperation(value = "根据id返回Resource")
    @ApiImplicitParam(name = "id", value = "Resource的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<Resource> get(@PathVariable(name = "id") Long id) { return R.ok(resourceService.getResourceById(id));}

    @ApiOperation(value = "根据对象返回带分页的Resource")
    @ApiImplicitParam(name = "resource", value = "待查询的Resource", required = true, dataTypeClass = Resource.class, paramType = "body")
    @PostMapping()
    public R<IPage<Resource>> page(@RequestBody Resource resource) {
        return R.ok(resourceService.pageByResource(resource));
    }

    @ApiOperation(value = "删除Resource", notes = "根据主键id删除Resource ")
    @ApiImplicitParam(name = "id", value = "Resource的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(resourceService.deleteResourceById(id));
    }

}
