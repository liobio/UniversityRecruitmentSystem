package com.liobio.demo.common.config;

import com.liobio.demo.common.utils.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private TokenWhiteListConfig whiteListConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")// 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns(whiteListConfig.getWhiteList());  // 放行静态文件
//
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }



}
