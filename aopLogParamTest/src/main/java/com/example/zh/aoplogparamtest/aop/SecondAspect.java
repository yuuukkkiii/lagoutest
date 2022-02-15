package com.example.zh.aoplogparamtest.aop;

/**
 * @Author: zhaih
 * @Date: 2022/2/14
 * @Time: 10:05
 * @Description:  用来测试@order的功能
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecondAspect {
//    这部分代码与ReqLogAspect内一样，用来测试执行顺序
    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.example.zh.aoplogparamtest.aop.ReqLog)")
    private void reqLogPointcut(){}
    /**
     * @param joinPoint 切点
     * @return @PathVariable 注解传递的参数的处理
     */
    @Around("reqLogPointcut()")
    public Object reqLogAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========进入切面2========");
        Object[] objects =joinPoint.getArgs();
        //String id= ((JSONObject)objects[0]).getString("id");
        System.out.println("切面截取的id为："+objects[0].toString());
        Object[] objChange=new Object[1];
        objChange[0]="4";
        return joinPoint.proceed(objChange);
    }
}
