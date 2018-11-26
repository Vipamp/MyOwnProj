/**
 * File: LoggerAspect.java 　　2018/11/25 13:37
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 编写切面
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.AOP.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * 编写切面：
 * 1、类要加上两个注解：
 *
 * @Aspect: 表示该类是一个切面
 * @Component: 注解该类被ICO管理（切面类，都需要生成bean对象，被IOC管理，通常使用Component注解）
 * <p>
 * 2、按照需要自定义切面方法
 * @Before： 前置通知，在指定方法执行前，执行该方法
 * @After： 后置通知，在指定方法执行后，指定该方法，该方法获取不到指定方法的返回结结果，不管有没有抛异常，后置切面都会被调用
 * @AfterReturning: 返回通知，方法正常结束时，执行该方法
 * @AfterThrowing： 异常通知，方法抛异常时，执行该方法
 * @Around： 环绕通知，可以理解成动态代理，包含方法执行前后的全过程，也可以决定被调用方法是否执行
 *
 * <p>
 * 几种通知的具体位置和执行区别 ，详见动态代理 {@link com.heqingsong.Spring.AOP.Proxy.DynamicProxy.CalculatorProxy#getCalculatorProxy}
 * @author：HeQingsong
 */
@Aspect
@Component
public class LoggerAspect {

    /**
     * 前置通知
     *
     * @param joinPoint : 执行方法的相关信息，可以通过该对象获取到调用的方法名和参数
     * @author：HeQingsong
     */
    @Before("execution(public int com.heqingsong.Spring.AOP.Annotation.CalcInterface.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@Before: call method " + methodName + " args are: " + args);
    }

    /**
     * 后置通知，不管方法有没有抛异常，后置通知方法都会去执行，获取不到方法的返回结果
     *
     * @param joinPoint :
     * @author：HeQingsong
     */
    @After("execution(public int com.heqingsong.Spring.AOP.Annotation.CalcInterface.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@After: call method " + methodName + " end");
    }

    /**
     * 返回通知，在方法正常结束之后执行的通知，是可以获取到方法的返回结果的，在AfterReturning中设置返回结果的变量
     *
     * @param joinPoint :
     * @author：HeQingsong
     */
    @AfterReturning(value = "execution(public int com.heqingsong.Spring.AOP.Annotation.CalcInterface.*(int,int))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterReturning: call method " + methodName + " end, result is " + result);
    }

    /**
     * 异常通知，在方法抛异常时执行
     *
     * @param joinPoint : 方法的执行信息7
     * @param e         : 方法执行时抛出的异常
     * @author：HeQingsong
     */
    @AfterThrowing(value = "execution(public int com.heqingsong.Spring.AOP.Annotation.CalcInterface.*(int,int))",
            throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method " + methodName + " occurs with Exception" + e);
    }

    /**
     * 环绕通知，可以在环绕通知里面编写以上4个基本通知类型的全部内容
     * 如下是环绕通知的标准格式，不同位置表示不同的基本通知内容。
     * 环绕通知，是通过 ProceedingJoinPoint 对象，调用 proceed 方法，来调用主程序的调用方法，这里可以控制主程序的方法是否
     * 需要调用，以上的4个基本通知类型，没有这个功能。
     *
     * @param pjp :
     * @return : int
     * @author：HeQingsong
     */
    @Around(value = "execution(public int com.heqingsong.Spring.AOP.Annotation.CalcInterface.*(int,int))")
    public int around(ProceedingJoinPoint pjp) {
        Object proceed = 0;
        String methodName = pjp.getSignature().getName();
        List<Object> args = Arrays.asList(pjp.getArgs());
        try {
            // 1、前置通知
            System.out.println("@Before: call method " + methodName + " args are: " + args);

            // 调用主程序调用的方法，并返回其执行结果。
            proceed = pjp.proceed();

            // 2、返回通知
            System.out.println("@AfterReturning: call method " + methodName + " end, result is " + proceed);
        } catch (Throwable throwable) {
            // 3、异常通知
            System.out.println("@AfterThrowing: the method " + methodName + " occurs with Exception" + throwable);
        }
        // 4、后置通知
        System.out.println("@After: call method " + methodName + " end.");
        return (int) proceed;
    }
}
