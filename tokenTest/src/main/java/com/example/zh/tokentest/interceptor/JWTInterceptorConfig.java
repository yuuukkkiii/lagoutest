package com.example.zh.tokentest.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: zhaih
 * @Date: 2022/2/17
 * @Time: 9:57
 * @Description:
 */
public class JWTInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor();
        WebMvcConfigurer.super.addInterceptors(registry);
    }

//    @Bean
//    public  JwtAuthenticationInterceptor authenticationInterceptor(){
//        return new J
//    }
}
