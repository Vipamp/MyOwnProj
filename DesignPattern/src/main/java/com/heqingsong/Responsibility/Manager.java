/**
 * File: Menager.java 　　2018/11/19 10:17
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

public class Manager extends Leader {
    public String LEADERJOB = "manager";

    @Override
    void treasRequest(HolidayRequest holidayRequest) {
        if (holidayRequest.getDays() < 2) {
            System.out.println(LEADERJOB + " approve:" + holidayRequest + "\n");
        } else {
            if (null != nextLeader) {
                System.out.println(LEADERJOB + " transmite to " + nextLeader.LEADERJOB);
                nextLeader.treasRequest(holidayRequest);
            }
        }
    }
}
