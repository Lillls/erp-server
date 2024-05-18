package com.xjx.production.controller.basic;


import com.xjx.production.base.R;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.service.basic.ForbiddenWordService;
import com.xjx.production.entity.basic.ForbiddenWord;
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
 * @since 2024-05-18
 */
@RestController
@RequestMapping("/forbiddenWord")
public class ForbiddenWordController {
    /**
     * forbiddenWord业务处理类
     */
    @Autowired
    ForbiddenWordService forbiddenWordService;

    @ApiOperation(value = "新增/更新ForbiddenWord", notes = "id为空是新建，非空是更新;更新全部字段")
    @ApiImplicitParam(name = "forbiddenWord", value = "待保存的ForbiddenWord", required = true, dataTypeClass = ForbiddenWord.class, paramType = "body")
    @PutMapping
    public R<Long> save(@RequestBody ForbiddenWord forbiddenWord) {
        return R.ok(forbiddenWordService.saveForbiddenWord(forbiddenWord));
    }

    @ApiOperation(value = "新增/更新非空字段ForbiddenWord", notes = "id为空是新建，非空是更新;只更新非空字段")
    @ApiImplicitParam(name = "forbiddenWord", value = "待保存的ForbiddenWord", required = true, dataTypeClass = ForbiddenWord.class, paramType = "body")
    @PatchMapping
    public R<Long> savePatch(@RequestBody ForbiddenWord forbiddenWord) {
        return R.ok(forbiddenWordService.saveForbiddenWordNotNull(forbiddenWord));
    }

    @ApiOperation(value = "根据id返回ForbiddenWord")
    @ApiImplicitParam(name = "id", value = "ForbiddenWord的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @GetMapping("/{id}")
    public R<ForbiddenWord> get(@PathVariable(name = "id") Long id) { return R.ok(forbiddenWordService.getForbiddenWordById(id));}

    @ApiOperation(value = "根据对象返回带分页的ForbiddenWord")
    @ApiImplicitParam(name = "forbiddenWord", value = "待查询的ForbiddenWord", required = true, dataTypeClass = ForbiddenWord.class, paramType = "body")
    @PostMapping()
    public R<IPage<ForbiddenWord>> page(@RequestBody ForbiddenWord forbiddenWord) {
        return R.ok(forbiddenWordService.pageByForbiddenWord(forbiddenWord));
    }

    @ApiOperation(value = "删除ForbiddenWord", notes = "根据主键id删除ForbiddenWord ")
    @ApiImplicitParam(name = "id", value = "ForbiddenWord的主键", required = true, dataTypeClass = Long.class, paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable(name = "id") Long id) {
        return R.ok(forbiddenWordService.deleteForbiddenWordById(id));
    }

}
