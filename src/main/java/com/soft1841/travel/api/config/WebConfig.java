package com.soft1841.travel.api.config;


import com.soft1841.travel.api.interceptor.JwtInterceptor;
import com.soft1841.travel.api.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName WebConfig
 * @Description 注册拦截器等Web配置
 * @Author wanghuanle
 * @Date 2020/4/15
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Resource
    private JwtInterceptor jwtInterceptor;

    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/sysAdmin/login",
                "/captcha", "/oauth2/code/github","http://localhost:8088/*","/oauth2/code").excludePathPatterns("/static/**");
    }
}


