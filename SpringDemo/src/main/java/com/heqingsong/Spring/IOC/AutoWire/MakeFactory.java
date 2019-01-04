/**
 * File: MakeFactory.java 　　2018/11/24 19:45
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.AutoWire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("makeFactory")
public class MakeFactory implements Factory {

    /**
     * Autowired，是将IOC容器中的bean，如果名称匹配上，就自动装配到参数上，如果IOC容器中没有，会报错
     * 如果IOC中没有bean对象时，不想报错，@Autowired加上required参数，值为false，不加默认为true
     */
    @Autowired(required = false)
    CarFactory carFactory;

    com.heqingsong.Spring.IOC.AutoWire.TrainFactory trainFactory;

    public void setCarFactory(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    /**
     * Autowired, 可以在属性上修饰装配，也可以在对应属性的set方法上修饰装配
     * 如果IOC中的bean对象的名称，和属性名称不一致，可以通过@Qualifier指定IOC的bean名称，装配到该属性中
     */
    @Autowired
    @Qualifier("myTrainFactory")
    public void setTrainFactory(com.heqingsong.Spring.IOC.AutoWire.TrainFactory trainFactory) {
        this.trainFactory = trainFactory;
    }

    @Override
    public void make() {
        carFactory.make();
        trainFactory.make();
    }
}
