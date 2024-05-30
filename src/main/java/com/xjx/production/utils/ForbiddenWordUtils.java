package com.xjx.production.utils;

import java.util.List;

import com.xjx.production.service.basic.ForbiddenWordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.plugin.CheckInputParameterAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author: lixiaoyu
 * Date:   2024/5/21 17:00
 */
@Component
@Slf4j
public class ForbiddenWordUtils {

  @Autowired
  private ForbiddenWordService forbiddenWordService;

  private List<ForbiddenWord> forbiddenWords;

  @PostConstruct
  public void init() {
    this.forbiddenWords = forbiddenWordService.queryForbiddenWord();;
  }

  public List<ForbiddenWord> getForbiddenWords() {
    return forbiddenWords;
  }

  public String checkAndReplace(String originalString) {
    for (ForbiddenWord forbiddenWord : forbiddenWords) {
      if (originalString.contains(forbiddenWord.getWord())) {
        log.info("发现违禁词 " + originalString);
        originalString = originalString.replace(forbiddenWord.getWord(), "");
      }
    }
    return originalString;
  }
}
