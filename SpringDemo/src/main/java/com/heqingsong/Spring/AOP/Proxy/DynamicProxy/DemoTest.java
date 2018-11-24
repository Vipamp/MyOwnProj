/**
 * File: DemoTest.java 　　2018/11/24 23:15
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.AOP.Proxy.DynamicProxy;

import com.heqingsong.Spring.AOP.Proxy.CalcInterface;
import com.heqingsong.Spring.AOP.Proxy.Calculator;

public class DemoTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalcInterface calculatorProxy = new CalculatorProxy(calculator).getCalculatorProxy();

        System.out.println("9 + 3 = " + calculatorProxy.add(1, 2));
        System.out.println("9 - 3 = " + calculatorProxy.sub(1, 2));
        System.out.println("9 * 3 = " + calculatorProxy.mul(1, 2));
        System.out.println("9 / 3 = " + calculatorProxy.div(1, 2));
    }
}
