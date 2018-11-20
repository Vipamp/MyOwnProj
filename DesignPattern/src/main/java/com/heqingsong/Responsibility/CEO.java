/**
 * File: CEO.java 　　2018/11/19 11:56
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Responsibility;

public class CEO extends Leader {
    public String LEADERJOB = "CEO";

    @Override
    void treasRequest(HolidayRequest holidayRequest) {
        if (holidayRequest.getDays() > 5) {
            System.out.println(LEADERJOB + " refuce " + holidayRequest + "\n");
        } else {
            System.out.println(LEADERJOB + " approve " + holidayRequest + "\n");
        }
    }
}
