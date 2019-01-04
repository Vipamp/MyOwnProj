/**
 * File: DemoTest.java 　　2018/11/24 17:42
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.AnnotationBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoTest2 {
    public static void main(String[] args) {
        // 2. 加载 配置类 获取Context对象，这个配置类，必须要加上 @Configuration 注解，才能获取里面的 Bean 注解过的 bean对象
        // 也可以直接指定添加注解类的bean对象
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class, MyComponent2.class);

        // 或者通过扫描包的方式获取ctx对象，会自动创建该包下的 @Configuration, @Component, @Service, @Controller 注解，创建bean对象
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.heqingsong.Spring.IOC.AnnotationBean");

        MyComponent myComponent = (MyComponent) ctx.getBean("myComponent");
        System.out.println(myComponent);

        MyService myService = (MyService) ctx.getBean("service");
        System.out.println(myService);

        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController);

        MyComponent2 myComponent2 = (MyComponent2) ctx.getBean("myComponent2");
        System.out.println(myComponent2);
    }
}
