/**
 * File: HelloControl.java 　　2018/11/24 6:15
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.SpringBootDemo.Web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }


    @RequestMapping("/test")
    public Map<Long, Object> test() {
        Map<Long, Object> map = new HashMap<>();
        User user = new User();
        Date date = new Date();

        user.setBirthDay(date);
        user.setRegisterDate(date);
        user.setId((long) (Math.random() * 50000));
        user.setName("张si丰");

        map.put(user.getId(), user);
        return map;
    }
}
