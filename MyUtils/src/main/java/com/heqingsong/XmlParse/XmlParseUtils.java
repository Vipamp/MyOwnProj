/**
 * File: XmlParseUtils.java 　　2018/10/30 15:28
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * the tool for parsing xml file to HashMap, you can see class XmlParseUtilsTest to get specific test demo
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.XmlParse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class XmlParseUtils {
    private static Logger logger = LoggerFactory.getLogger(XmlParseUtils.class);

    private static Document doc = null;
    private static HashMap<String, String> confMap = new HashMap<String, String>();

    /**
     * @param xmlFilePath :  the file to parse
     * @return : java.util.HashMap<java.lang.String,java.lang.String>   the result after parse
     * @author：HeQingsong
     * @date：17:29 2018/10/30
     */
    public static HashMap<String, String> parseXmlByFileConf(String xmlFilePath) {
        try {
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(new File(xmlFilePath));
            logger.info(" parse file {} success !", xmlFilePath);
        } catch (Exception e) {
            logger.error(" parse file {} file error! please make sure file {} if exists and be a xml file",
                    xmlFilePath, xmlFilePath);
        }
        Element rootElement = doc.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        recursionParse(iterator, new StringBuffer());
        return confMap;
    }

    /**
     * according to iterator to recurrence xml context, and transformate xml context to map and return
     *
     * @param it   : the iterator for representing xml context
     * @param path : the iterator's path, represent params path
     * @return : void
     * @author：HeQingsong
     * @date：17:31 2018/10/30
     */
    private static void recursionParse(Iterator<Element> it, StringBuffer path) {
        while (it.hasNext()) {
            Element next = it.next();
            Iterator<Element> sonIt = next.elementIterator();
            if (sonIt.hasNext()) {
                path.append(next.getName());
                recursionParse(sonIt, path.append("-"));
            } else {
                confMap.put(path.toString() + next.getName(), next.getStringValue());
            }
        }
    }
}
