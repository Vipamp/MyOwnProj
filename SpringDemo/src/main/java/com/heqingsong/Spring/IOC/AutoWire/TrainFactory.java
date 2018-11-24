/**
 * File: TrainFacotry.java 　　2018/11/24 19:44
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

import org.springframework.stereotype.Component;

@Component("myTrainFactory")
public class TrainFactory implements Factory {

    @Override
    public void make() {
        System.out.println("make train ...");
    }
}
