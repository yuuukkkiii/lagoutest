package com.example.zh.redistest.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaih
 * @Date: 2022/3/6
 * @Time: 16:24
 * @Description:
 */
@Configuration
public class CaffeineCacheConfig {

    @Bean
    public Cache<String,Object> caffeineCache(){
        return Caffeine.newBuilder()
                .expireAfterAccess(120L, TimeUnit.SECONDS)
                .maximumSize(1000)
                .build();
    }
}
