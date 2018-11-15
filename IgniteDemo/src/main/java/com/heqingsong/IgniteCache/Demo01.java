/**
 * @ClassName：Demo01
 * @Author：HeQingsong
 * @Date：2018/9/14 10:09
 * @Since：JDK1.8
 * @Version：1.0
 * @Description：ignite创建缓存的几种方法
 */
package com.heqingsong.IgniteCache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;

public class Demo01 {

    public static void createStaticCache(Ignite ignite) {
        //1、静态方式创建缓存
        IgniteCache<String, String> staticCache = ignite.getOrCreateCache("MyCache");
    }

    public static void createDymCache(Ignite ignite) {
        //2、动态方式创建缓存，可以设置原子模式和事务模式
        CacheConfiguration cfg = new CacheConfiguration();
        cfg.setName("myCache");
        cfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        IgniteCache<Integer, String> dynamicCache = ignite.getOrCreateCache(cfg);
    }

    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        createStaticCache(ignite);
        createDymCache(ignite);
        ignite.close();
    }
}
