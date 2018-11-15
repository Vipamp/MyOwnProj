/**
 * File: AbstractObjectPojo.java 　　2018/10/30 23:46
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * the object model that you want to save object to ignite. If you want to save objects to ignite as records, you
 * need to create your class extends class AbstarctObjectPojo, and implement other four functions.
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgniteORM;

import java.util.Map;

public abstract class AbstractPojoModel<T> {

    /**
     * when you want to save an object to ignite cache as a record, you must set a key to flag this object, this function
     * is used to create key by the object.
     *
     * @return : java.lang.String
     */
    abstract public String keyBuilder();

    /**
     * this function is used to get cache name by {@link com.heqingsong.IgniteUtils.IgniteORM.CachePool#getOrPushIgniteCache(Class)}
     *
     * @return : java.lang.String
     */
    abstract public String getCacheName();

    /**
     * this function is used to create a object by map
     *
     * @param map :
     * @return : T
     */
    abstract public T mapToObject(Map<String, Object> map);

    /**
     * this function is used to create a map by object
     *
     * @param object :
     * @return : java.util.Map
     */
    abstract public Map<String, Object> objectToMap(T object);
}
