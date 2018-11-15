/**
 * File: CachePool.java 　　2018/10/31 23:09
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * this class is uesd to initialize ignite cache by config, then return IgniteCache
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgniteORM;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

public class CacheBuilder {
    private static Ignite ignite = null;

    public static void init(Ignite ignite) {
        CacheBuilder.ignite = ignite;
    }

    /**
     * builder ignite cache instance
     *
     * @param cacheName : cache name
     * @param clazz     : the Class instance of ignite cache type
     * @return : org.apache.ignite.IgniteCache<java.lang.String,com.heqingsong.IgniteUtils.IgniteORM.AbstractPojoModel
     * @author：HeQingsong
     * @date：15:59 2018/11/9
     */
    public static IgniteCache<String, AbstractPojoModel> getIgniteCache(String cacheName, Class clazz) {
        CacheConfiguration<String, AbstractPojoModel> classCacheCfg = new CacheConfiguration<>();
        classCacheCfg.setName(cacheName);
        classCacheCfg.setCacheMode(CacheMode.PARTITIONED);
        classCacheCfg.setIndexedTypes(String.class, clazz);
        return ignite.getOrCreateCache(classCacheCfg);
    }
}
