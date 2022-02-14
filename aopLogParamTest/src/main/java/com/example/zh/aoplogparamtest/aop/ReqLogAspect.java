package com.example.zh.aoplogparamtest.aop;

/**
 * @Author: zhaih
 * @Date: 2022/2/14
 * @Time: 10:05
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.zh.aoplogparamtest.dto.req.UserBaseReq;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Aspect
public class ReqLogAspect {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void logAdvicePointcutPost() {}





    // Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("get请求的advice触发了");
    }

    @Before("logAdvicePointcutPost()")
    public void logAdvicePost(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("post请求的advice触发了");
    }


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
        System.out.println("========进入切面========");
        Object[] objects =joinPoint.getArgs();
        //String id= ((JSONObject)objects[0]).getString("id");
        System.out.println("切面截取的id为："+objects[0].toString());
        Object[] objChange=new Object[1];
        objChange[0]="3";
        return joinPoint.proceed(objChange);
    }
    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.example.zh.aoplogparamtest.aop.Payload)")
    private void payloadPointcut(){}

    /**
     * @param joinPoint 切点
     * @return @PathVariable 注解传递的参数的处理
     */
    @Around("payloadPointcut()")
    public Object payloadAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========进入切面========");
        Object[] objects =joinPoint.getArgs();
        int index=0;
        for(Object obj:objects){
            System.out.println("参数列表--参数"+(index++)+"       "+obj);
        }
        objects[0]="小红";
        objects[1]=4;
        return joinPoint.proceed(objects);
    }


    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.example.zh.aoplogparamtest.aop.PostParam)")
    private void postParamPointcut(){}

    /**
     * @param joinPoint 切点
     * @return @PathVariable 注解传递的参数的处理
     */
    @Around("postParamPointcut()")
    public Object postParamAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========进入切面========");
        Object[] objects =joinPoint.getArgs();
        int index=0;
        for(Object obj:objects){
            System.out.println("参数列表--参数"+(index++)+"       "+obj);
        }
        String reqStr =JSON.toJSONString(objects[0]);
        UserBaseReq req =JSONObject.parseObject(reqStr,UserBaseReq.class);
        req.setId(10L);
        objects[0]=req;
        return joinPoint.proceed(objects);
    }



    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.example.zh.aoplogparamtest.aop.JoinPointTest)")
    private void testPointcut(){}

    /**
     * @param joinPoint 切点
     * @return @PathVariable 注解传递的参数的处理
     */
    @Around("testPointcut()")
    public Object testAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========进入切面========");
        System.out.println("getKind()方法：   "+joinPoint.getKind());
        Signature signature =joinPoint.getSignature();
        /*
        getName: 本次调用的方法的方法名
        toString：只打印了调用方法的完整路径和返回类型
        getDeclaringTypeName： 返回本次调用方法所属类的类名
        getDeclaringType: 同上，不过返回的是Class类型
        toLongString: 连接点位置的详细信息，全部信息
        toShortString：连接点所在位置的简略描述
        getModifiers：修饰符，返回值为数字常数，如 1，2，3，表示public final abstract等
        * */
        System.out.println("getSignature()方法：  getName:  "+signature.getName() +"   toString: "+signature.toString()+"" +
                "\n    getDeclaringTypeName  "+signature.getDeclaringTypeName()+"     getDeclaringType  "+signature.getDeclaringType()+
                "\n     toLongString  "+signature.toLongString()+"\n     toShortString  "+signature.toShortString()+
                "\n     getModifiers   "+signature.getModifiers());
        return joinPoint.proceed();
    }

}
