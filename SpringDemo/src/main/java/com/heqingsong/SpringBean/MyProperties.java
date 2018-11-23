/**
 * File: MyProperties.java 　　2018/11/22 16:17
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.SpringBean;

import java.util.Properties;

public class MyProperties {

    Properties properties;

    public MyProperties() {
    }

    public MyProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MyProperties{" + "properties=" + properties + '}';
    }
}
