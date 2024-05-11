package com.xjx.production.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjx.production.base.R;
import com.xjx.production.dto.user.MemberDetails;
import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.repository.user.UmsMemberRepository;
import com.xjx.production.security.jwt.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理
 * 1.生成jwt
 * 2.返回json
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UmsMemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("【AuthenticationSuccessHandler】登录成功处理 authentication:{}", new ObjectMapper().writeValueAsString(authentication));
        MemberDetails details = (MemberDetails)authentication.getPrincipal();
        String jwt = jwtTokenUtil.generateToken(details);
        /**
         * token先写进数据库，应该进redis，但是现在没有
         */
        memberRepository.updateToken(details.getUmsMember().getId(), jwt);
        details.getUmsMember().setToken(jwt);
        details.getUmsMember().setPassword(null);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        R<UmsMember> ok = R.ok(details.getUmsMember());
        response.getWriter().write(new ObjectMapper().writeValueAsString(ok));
    }
}
