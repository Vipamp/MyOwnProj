/**
 * File: BaseService.java 　　2018/11/24 20:35
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.GenericityAutoWired;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
    @Autowired
    BaseComponent<T> baseComponent;

    public void add() {
        System.out.println("BaseService add...");
        System.out.println(baseComponent);
    }

}
