package com.soft1841.travel.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author Guorc
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "travel-assient-api Swagger 文档",
                "github地址 https://github.com/WHL1998w/travel-assient-api",
                "API V1.0",
                "Terms of service",
                new Contact("wanghuanle", "https://wanghuanle.cn", "1162608075@qq.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soft1841.travel.api"))
                .build()
                .apiInfo(apiInfo());
    }
}
