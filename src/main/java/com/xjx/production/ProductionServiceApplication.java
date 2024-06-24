package com.xjx.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableKnife4j
@EnableAspectJAutoProxy
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class ProductionServiceApplication {

    public static void main(String[] args) throws JsonProcessingException {
        ConfigurableApplicationContext run = SpringApplication.run(ProductionServiceApplication.class, args);
        System.out.println(new ObjectMapper().writeValueAsString(run.getBeanDefinitionNames()));
    }

}
