package com.xjx.production.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjx.production.base.R;
import com.xjx.production.base.ResultCode;
import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.repository.user.UmsMemberRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogMessage;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


/**
 * 登录之后获取jwt
 * 所有请求的请求头必须带有Authentication:Bearer
 */

@Component
public class JwtBasicAuthenticationFilter extends GenericFilterBean {

    @Autowired
    UmsMemberRepository memberRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    private final RequestMatcher requiresAuthenticationRequestMatcher;

    public JwtBasicAuthenticationFilter(){
        this.requiresAuthenticationRequestMatcher = new AntPathRequestMatcher("/login", "POST");;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
       doFilterInternal((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, chain);
    }

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("调用JwtFilter");
        /**
         * 如果是登录接口放行，否则认证token，没有token的一律401
         */
        if(requiresAuthentication(request, response)){
            chain.doFilter(request, response);
        }else {
            String authorization_header = request.getHeader("Authorization");
            if(!StringUtils.hasLength(authorization_header)){
                writeUnAuthentication(response, "未获取到Authorization信息!");
                return;
            }

            if(!authorization_header.contains("Bearer ")){
                writeUnAuthentication(response, "Authorization格式不正确!");
                return;
            }

            String jwt = authorization_header.replace("Bearer ","");
            try {
                String usernameFromToken = jwtTokenUtil.getUsernameFromToken(jwt);

                UmsMember umsMember = memberRepository.queryMemberByUserName(usernameFromToken);
                if(Objects.isNull(umsMember) || !umsMember.getToken().equalsIgnoreCase(jwt)){
                    writeUnAuthentication(response, "token不存在，请重新登录!");
                    return;
                }

                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usernameFromToken,null,null);
                SecurityContextHolder.getContext().setAuthentication(token);
                chain.doFilter(request,response);

            }catch (ExpiredJwtException e){
                writeUnAuthentication(response, "token已过期，请重新登录!");
            } catch ( UnsupportedJwtException | MalformedJwtException | SignatureException e){
                writeJwtException(response, e.getMessage());
            }
        }


    }

    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        if (this.requiresAuthenticationRequestMatcher.matches(request)) {
            return true;
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(LogMessage.format("Did not match request to %s", this.requiresAuthenticationRequestMatcher));
            }

            return false;
        }
    }


    public void writeUnAuthentication(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        R<Object> unAuthentication = R.fail(message, ResultCode.UNAUTHORIZED.getCode());
        response.getWriter().write(new ObjectMapper().writeValueAsString(unAuthentication));
    }

    public void writeJwtException(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        R<Object> serverError = R.fail(message, ResultCode.EXCEPTION.getCode());
        response.getWriter().write(new ObjectMapper().writeValueAsString(serverError));
    }
}