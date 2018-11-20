/**
 * File: DemoTest.java 　　2018/11/19 11:59
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

public class DemoTest {
    public static Leader getResponsibilityChain() {
        Leader ceo = new CEO();
        Leader manager = new Manager();
        manager.setNextLeader(ceo);
        return manager;
    }

    public static void main(String[] args) {
        Leader chain = getResponsibilityChain();
        HolidayRequest holidayRequest = new HolidayRequest("HQS", 1, "sleep");
        chain.treasRequest(holidayRequest);

        HolidayRequest holidayRequest2 = new HolidayRequest("HQS2", 3, "ill");
        chain.treasRequest(holidayRequest2);

        HolidayRequest holidayRequest3 = new HolidayRequest("HQS3", 10, "ill");
        chain.treasRequest(holidayRequest3);
    }
}
