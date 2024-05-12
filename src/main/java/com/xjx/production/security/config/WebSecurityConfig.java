package com.xjx.production.security.config;

import com.xjx.production.security.jwt.JwtBasicAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginUserDetailsService loginUserDetailsService;

    @Autowired
    LoginUsernamePasswordJsonFilter loginUsernamePasswordJsonFilter;

    @Autowired
    UnAuthenticationEntryPoint unAuthenticationEntryPoint;

    @Autowired
    JwtBasicAuthenticationFilter jwtBasicAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 这个配置用作form表单提交时，走这个配置
         * json不走这个配置
         */
        auth.userDetailsService(loginUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().permitAll()
                .and().authorizeRequests()
                .antMatchers("/oauth/**","/test/**","/login").permitAll()
                .anyRequest()
                .authenticated()
                .and().logout().permitAll()
                .and().csrf().disable()
                .addFilterBefore(loginUsernamePasswordJsonFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                //.exceptionHandling().authenticationEntryPoint(unAuthenticationEntryPoint);
    }
}