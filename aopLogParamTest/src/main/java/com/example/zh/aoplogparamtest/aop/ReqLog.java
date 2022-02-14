package com.example.zh.aoplogparamtest.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhaih
 * @Date: 2022/2/14
 * @Time: 10:02
 * @Description: 请求参数日志记录
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqLog {
    String name() default "";
    String value() default "";
}
