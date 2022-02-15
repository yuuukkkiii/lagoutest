package com.example.zh.aoplogparamtest.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhaih
 * @Date: 2022/2/14
 * @Time: 14:50
 * @Description: payload方式携带的请求参数
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Payload {
    String value() default "";
}
