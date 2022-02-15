package com.example.zh.aoplogparamtest.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhaih
 * @Date: 2022/2/14
 * @Time: 16:05
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinPointTest {
    String value() default "";
}
