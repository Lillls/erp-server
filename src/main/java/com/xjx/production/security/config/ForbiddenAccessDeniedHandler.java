package com.xjx.production.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjx.production.base.R;
import com.xjx.production.base.ResultCode;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ForbiddenAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        String message = new ObjectMapper().writeValueAsString(R.fail(accessDeniedException.getMessage(), ResultCode.FORBIDDEN.getCode()));
        response.getWriter().write(message);
    }
}
