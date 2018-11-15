/**
 * File: XmlParseUtilsTest.java 　　2018/10/30 13:35
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.XmlParse.test;

import com.heqingsong.XmlParse.XmlParseUtils;

import java.util.HashMap;
import java.util.Map;

public class XmlParseUtilsTest {

    private static final String XMLFILENMAE = "MyUtils/src/main/resources/XmlParseTestFile.xml";

    /**
     * the main function is used to test class {@link com.heqingsong.XmlParse.XmlParseUtils} for parse xml file to Map
     *
     * @param args :
     * @return : void
     * @author：HeQingsong
     * @date：14:00 2018/10/30
     */
    public static void main(String[] args) {
        HashMap<String, String> xmlMap = XmlParseUtils.parseXmlByFileConf(XMLFILENMAE);
        for (Map.Entry<String, String> entry : xmlMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
