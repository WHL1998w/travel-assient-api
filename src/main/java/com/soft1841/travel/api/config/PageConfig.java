package com.soft1841.travel.api.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName PageConfig
 * @Description TODO
 * @Author wanghuanle
 * @Date 2021/03/08
 * @Version 1.0
 */
@Configuration
public class PageConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
