/**
 * File: CirclePool.java 　　2018/11/18 15:31
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.ShareUnit;

import java.util.HashMap;
import java.util.Map;

public class CirclePool {

    public static Map<String, Circle> mapPool = new HashMap<String, Circle>();

    public static Circle getCirclrInstance(int x, int y, int r) {
        String key = String.valueOf(x) + String.valueOf(y) + String.valueOf(r);
        Circle circle = mapPool.get(key);
        if (null == circle) {
            circle = new Circle(x, y, r);
            mapPool.put(key, circle);
        }
        return circle;
    }
}
