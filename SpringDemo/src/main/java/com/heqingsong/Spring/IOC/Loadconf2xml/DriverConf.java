/**
 * File: DriverConf.java 　　2018/11/24 2:27
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.Loadconf2xml;

public class DriverConf {
    String driver;
    String user;
    String passwd;
    String url;

    public DriverConf() {
    }

    public DriverConf(String driver, String user, String passwd, String url) {
        this.driver = driver;
        this.user = user;
        this.passwd = passwd;
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DriverConf{" + "driver='" + driver + '\'' + ", user='" + user + '\'' + ", passwd='" + passwd + '\'' + ", url='" + url + '\'' + '}';
    }
}
