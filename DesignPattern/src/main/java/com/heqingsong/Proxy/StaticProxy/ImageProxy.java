/**
 * File: ImageProxy.java 　　2018/11/17 23:26
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Proxy.StaticProxy;

public class ImageProxy implements Image {

    String fileName;
    Image image;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(fileName);
        }
        image.display();
    }
}
