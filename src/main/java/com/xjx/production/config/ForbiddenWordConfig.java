package com.xjx.production.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.service.basic.ForbiddenWordService;
import com.xjx.production.utils.ForbiddenWordUtils;

/**
 * Author: lixiaoyu
 * Date:   2024/5/21 17:00
 */
@Configuration
public class ForbiddenWordConfig {
  @Autowired
  ForbiddenWordService forbiddenWordService;

  @Bean
  public ForbiddenWordUtils initForbiddenWordUtils() {
    ForbiddenWordUtils forbiddenWordUtils = new ForbiddenWordUtils();
    List<ForbiddenWord> forbiddenWords = forbiddenWordService.queryForbiddenWord();
    forbiddenWordUtils.init(forbiddenWords);
    return forbiddenWordUtils;
  }
}
