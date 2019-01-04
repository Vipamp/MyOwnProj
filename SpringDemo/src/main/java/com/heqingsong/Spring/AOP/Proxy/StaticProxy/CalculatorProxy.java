/**
 * File: CalculatorProxy.java 　　2018/11/25 0:43
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.AOP.Proxy.StaticProxy;

import com.heqingsong.Spring.AOP.Proxy.CalcInterface;
import com.heqingsong.Spring.AOP.Proxy.Calculator;

public class CalculatorProxy implements CalcInterface {
    Calculator calculator;

    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        return calculator.add(i, j);
    }

    @Override
    public int sub(int i, int j) {
        return calculator.sub(i, j);
    }

    @Override
    public int mul(int i, int j) {
        return calculator.mul(i, j);
    }

    @Override
    public int div(int i, int j) {
        return calculator.div(i, j);
    }
}