package com.xjx.production.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xjx.production.entity.basic.ForbiddenWord;
import com.xjx.production.plugin.CheckInputParameterAspect;

/**
 * Author: lixiaoyu
 * Date:   2024/5/21 17:00
 */
public class ForbiddenWordUtils {
  private static final Log Logger = LogFactory.getLog(CheckInputParameterAspect.class);

  private List<ForbiddenWord> forbiddenWords;

  public void init(List<ForbiddenWord> forbiddenWords) {
    this.forbiddenWords = forbiddenWords;
  }

  public List<ForbiddenWord> getForbiddenWords() {
    return forbiddenWords;
  }

  public String checkAndReplace(String originalString) {
    for (ForbiddenWord forbiddenWord : forbiddenWords) {
      if (originalString.contains(forbiddenWord.getWord())) {
        Logger.info("发现违禁词 " + originalString);
        originalString = originalString.replace(forbiddenWord.getWord(), "");
      }
    }
    return originalString;
  }
}
