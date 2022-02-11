package com.example.zh.mybatisplustest.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: zhaih
 * @Date: 2022/2/7
 * @Time: 17:25
 * @Description:
 */
@EnableTransactionManagement // 开启事务管理
@MapperScan("com.example.zh.mybatisplustest.mapper") // 扫描mapper接口
@Configuration
public class MyBatisPlusConfig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /*v3.2版本之上移除了PerformanceInterceptor性能分析插件*/
}
