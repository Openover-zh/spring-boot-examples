package com.example.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zhangJiaHao
 * @date 2022/11/20 17:30
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut(value = "execution(* com.example.service..*.*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before方法执行===="+ Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after 方法执行==="+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterRuturning(JoinPoint joinPoint,Object result){
        System.out.println("AfterReturning执行 args"+ Arrays.toString(joinPoint.getArgs())+"result: "+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Throwable ex){
        System.out.println("afterThrowing args"+ Arrays.toString(joinPoint.getArgs())+"throwable: "+ex.getMessage());

    }

}
