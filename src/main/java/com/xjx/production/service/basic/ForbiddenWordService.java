package com.xjx.production.service.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.repository.basic.ForbiddenWordMapper;
import com.xjx.production.repository.basic.ForbiddenWordRepository;

/**
 * <p>
 * ForbiddenWord业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-05-18
 */
@Service
public class ForbiddenWordService {

  /**
   * forbiddenWordMapper
   */
  @Autowired
  ForbiddenWordMapper forbiddenWordMapper;

  /**
   * forbiddenWordRepository
   */
  @Autowired
  ForbiddenWordRepository forbiddenWordRepository;

  /**
   * 保存/更新对象
   *
   * @param forbiddenWord 待处理对象
   * @return Long 主键
   */
  public Long saveForbiddenWord(ForbiddenWord forbiddenWord) {
    forbiddenWordRepository.saveOrUpdate(forbiddenWord);
    return forbiddenWord.getId();
  }

  /**
   * 保存/更新对象中的非空值
   *
   * @param forbiddenWord 待处理对象
   * @return Long 主键
   */
  public Long saveForbiddenWordNotNull(ForbiddenWord forbiddenWord) {
    forbiddenWordRepository.saveOrUpdatePatch(forbiddenWord);
    return forbiddenWord.getId();
  }

  /**
   * 根据主键查询对象
   *
   * @param id 主键
   * @return ForbiddenWord 对象实体
   */
  public ForbiddenWord getForbiddenWordById(Long id) {
    return forbiddenWordRepository.getById(id);
  }

  /**
   * 根据条件查询分页集合
   *
   * @param forbiddenWord 实体参宿对象
   * @return IPage<ForbiddenWord> 分页对象
   */
  public IPage<ForbiddenWord> pageByForbiddenWord(ForbiddenWord forbiddenWord) {
    return forbiddenWordRepository.pageByForbiddenWord(forbiddenWord);
  }

  /**
   * 查询所有数据
   *
   * @return List<ForbiddenWord> 数据结果集合
   */
  public List<ForbiddenWord> queryForbiddenWord() {
    return forbiddenWordRepository.list(null);
  }

  /**
   * 根据id删除对象
   *
   * @param forbiddenWord forbiddenWord违禁词
   * @return 是否删除成功 true：成功，false：失败
   */
  public void deleteForbiddenWordByName(String forbiddenWord) {
    forbiddenWordMapper.deleteForbiddenWordByName(forbiddenWord);
  }
}
