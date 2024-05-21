package com.xjx.production.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.base.R;
import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.service.basic.ForbiddenWordService;
import com.xjx.production.utils.ForbiddenWordUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * Restful api
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

  @Autowired
  ForbiddenWordUtils mForbiddenWordUtils;

  @ApiOperation(value = "新增/更新ForbiddenWord", notes = "id为空是新建，非空是更新;更新全部字段")
  @ApiImplicitParam(name = "forbiddenWord", value = "待保存的ForbiddenWord", required = true,
      dataTypeClass = ForbiddenWord.class, paramType = "body")
  @PostMapping("/add")
  public R<Long> save(@Param("forbiddenWord") String forbiddenWord) {
    ForbiddenWord forbiddenWord1 = new ForbiddenWord();
    forbiddenWord1.setWord(forbiddenWord);
    mForbiddenWordUtils.getForbiddenWords().add(forbiddenWord1);
    return R.ok(forbiddenWordService.saveForbiddenWord(forbiddenWord1));
  }

  @ApiOperation(value = "根据对象返回带分页的ForbiddenWord")
  @ApiImplicitParam(name = "forbiddenWord", value = "待查询的ForbiddenWord", required = true,
      dataTypeClass = ForbiddenWord.class, paramType = "body")
  @PostMapping("/listByPage")
  public R<IPage<ForbiddenWord>> page(
      @RequestParam(value = "current", required = false, defaultValue = "-1") int current,
      @RequestParam("size") int size) {
    ForbiddenWord forbiddenWord = new ForbiddenWord();
    forbiddenWord.setCurrent(current);
    forbiddenWord.setSize(size);
    forbiddenWord.setIsDelete(0);
    return R.ok(forbiddenWordService.pageByForbiddenWord(forbiddenWord));
  }

  @ApiOperation(value = "删除ForbiddenWord", notes = "根据主键id删除ForbiddenWord ")
  @ApiImplicitParam(name = "id", value = "ForbiddenWord的主键", required = true,
      dataTypeClass = Long.class, paramType = "path")
  @PostMapping("/delete")
  public R<Boolean> delete(@Param("forbiddenWord") String forbiddenWord) {
    forbiddenWordService.deleteForbiddenWordByName(forbiddenWord);
    return R.ok();
  }

}
