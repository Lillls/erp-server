package com.xjx.production.repository.basic;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.plugin.MyBaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2024-05-18
 */
@Component
public interface ForbiddenWordMapper extends MyBaseMapper<ForbiddenWord> {

  @Update(
      "UPDATE forbidden_word set is_delete = 1 where word = #{forbiddenWord}")
  void deleteForbiddenWordByName(@Param("forbiddenWord") String forbiddenWord);


}
