package com.heqingsong; /**
 * File: App 　　2019/09/07 01:44
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version 1.0
 * @author HeQingsong
 * @since JDK1.8
 */

import com.heqingsong.model.Car;
import com.heqingsong.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Person p1 = new Person();
        p1.setAge(20);
        Car car = new Car();
        car.setPerson(p1);

        kieSession.insert(car);

        int count = kieSession.fireAllRules();

        System.out.println(count);
        System.out.println(car.getDiscount());

        kieSession.dispose();
    }
}