package com.xjx.production.plugin;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: lixiaoyu
 * Date:   2024/5/21 16:36
 */

@Component
@Aspect
@Slf4j
public class CheckInputParameterAspect {
  private static final Log Logger = LogFactory.getLog(CheckInputParameterAspect.class);

  /**
   * 定义切入点:拦截controller层所有方法
   */
  @Pointcut("execution(public * com.xjx.production.controller.*Controller.*(..))")
  public void params() {
  }

  /**
   * 前置通知
   *
   * @param
   * @throws Throwable
   */
  @Before("params()")
  public Object before(JoinPoint point) throws Throwable {

    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
    //获取请求参数
    Object[] args = point.getArgs();

    return args;
  }

}
