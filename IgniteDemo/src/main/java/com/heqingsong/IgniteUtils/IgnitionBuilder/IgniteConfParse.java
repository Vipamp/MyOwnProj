/**
 * File: IgniteConfParse.java 　　2018/11/5 19:25
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * this class is used to parse ignition config XML file named "./src/main/resources/IgniteConf.xml", and return a map
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgnitionBuilder;

import com.heqingsong.XmlParse.XmlParseUtils;

import java.util.HashMap;

public class IgniteConfParse {
    /**
     * XMLFILENAME is used to point xml config file named IgniteCon.xml at path './src/main/resources/'
     */
    private static final String XMLFILENMAE = "IgniteDemo/src/main/resources/IgniteConf.xml";
    private static HashMap<String, String> confMap;

    public IgniteConfParse() {
    }

    /**
     * this function is used to get config map parsed from XML file
     *
     * @return : java.util.HashMap<java.lang.String,java.lang.String>
     * @author：HeQingsong
     * @date：12:14 2018/11/7
     */
    public static HashMap<String, String> getConfMap() {
        if (null == confMap) {
            confMap = XmlParseUtils.parseXmlByFileConf(XMLFILENMAE);
        }
        return confMap;
    }
}
