package com.soft1841.travel.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wanghuanle
 */

@SpringBootApplication
@MapperScan("com.soft1841.travel.api.mapper")
@ServletComponentScan
@EnableSwagger2
public class TravelAssientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAssientApplication.class, args);
    }

}
