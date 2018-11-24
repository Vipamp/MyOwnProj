/**
 * File: CalculatorProxy.java 　　2018/11/24 23:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 创建动态代理对象，方法getCalculatorProxy是生成代理对象的核心：
 * 1、依据被代理对象，获取对应的类加载器ClassLoader
 * 2、被代理对象类实现的接口，可以理解为，动态生成一个代理类，该代理类里面的方法，就是这个接口的方法。
 * （所以被代理对象，必须要实现一个接口，jvm是依据这个接口的方法，生成代理类的）
 * 3、接口方法的调用句柄，在这里需要手动通过反射的方式，调用被代理类的方法，前后都可以切面。
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.AOP.Proxy.DynamicProxy;

import com.heqingsong.Spring.AOP.Proxy.CalcInterface;
import com.heqingsong.Spring.AOP.Proxy.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy {


    Calculator target;

    public CalculatorProxy(Calculator target) {
        this.target = target;
    }

    /**
     * 获取代理类对象
     *
     * @return : CalcInterface
     * @author：HeQingsong
     */
    public CalcInterface getCalculatorProxy() {
        //1、通过被被代理对象的类，获取类加载器ClassLoader
        ClassLoader classLoader = target.getClass().getClassLoader();

        //2、指定被代理类的方法，在代理模式下，被代理类需要实现某接口，里面的方法才能做切面，
        Class<?>[] classes = new Class[]{CalcInterface.class};

        //3、创建代理对象的句柄，里面需要重写相关的方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 中间需要需要通过反射的方式，执行被代理对象的方法，并返回结果
             * 在反射执行方法前后，就是前后向切面。
             *
             * @param proxy : 正在返回的代理对象
             * @param method : 对象调用的方法
             * @param args : 对象调用时的参数
             * @return : java.lang.Object
             * @author：HeQingsong
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                Object result = method.invoke(target, args);
                System.out.println("execute method " + methodName + ", the result is " + result);
                return result;
            }
        };
        //4、依据类加载器、代理类需要实现的方法，和反射指定的句柄函数，动态创建一个代理被代理对象对应的代理对象。
        return (CalcInterface) Proxy.newProxyInstance(classLoader, classes, invocationHandler);
    }
}
