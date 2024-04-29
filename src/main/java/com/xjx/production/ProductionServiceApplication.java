package com.xjx.production;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.gson.JsonArray;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.codehaus.jettison.json.JSONArray;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableKnife4j
public class ProductionServiceApplication {

    public static void main(String[] args) throws JsonProcessingException {
        ConfigurableApplicationContext run = SpringApplication.run(ProductionServiceApplication.class, args);
        System.out.println(new ObjectMapper().writeValueAsString(run.getBeanDefinitionNames()));
    }

}
