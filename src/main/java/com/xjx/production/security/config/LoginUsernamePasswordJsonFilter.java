package com.xjx.production.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjx.production.base.R;
import com.xjx.production.entity.user.UmsMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class LoginUsernamePasswordJsonFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    PasswordEncoder credentialsPasswordEncoder;

    @Autowired
    LoginUserDetailsService loginUserDetailsService;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    public LoginUsernamePasswordJsonFilter(){
        super();
        setAuthenticationFailureHandler((request, response, exception) -> {
            log.warn("【AuthenticationFailureHandler】登录失败处理 AuthenticationException:{}", exception.getMessage());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("utf-8");
            R<Authentication> fail = R.fail(exception.getMessage());
            response.getWriter().write(new ObjectMapper().writeValueAsString(fail));
        });
    }

    @PostConstruct
    public void init(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(credentialsPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(loginUserDetailsService);
        ProviderManager providerManager = new ProviderManager(daoAuthenticationProvider);
        setAuthenticationManager(providerManager);
        setAuthenticationSuccessHandler(loginSuccessHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String contentType = request.getContentType();
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else if (contentType.contains(MediaType.APPLICATION_JSON_VALUE)){
            try {
                UmsMember member = new ObjectMapper().readValue(request.getInputStream(), UmsMember.class);
                String username = member.getUserName();
                String password = member.getPassword();
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("【LoginUsernamePasswordJsonFilter】登录失败 :{}", e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return super.attemptAuthentication(request,response);
    }
}
