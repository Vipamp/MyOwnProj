/**
 * @ClassName：Demo01
 * @Author：HeQingsong
 * @Date：2018/9/15 0:01
 * @Since：JDK1.8
 * @Version：1.0
 * @Description：缓存数据的get、put、remove操作、原子操作、事务性、分布式锁
 */
package com.heqingsong.IgniteCache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.transactions.Transaction;

import java.util.concurrent.locks.Lock;

public class Demo02 {
    /**
     * @Author：HeQingsong
     * @Date：14:00 2018/9/16
     * @Param [ignite]
     * @Return void
     * @Description：测试Ignite缓存的get、put和remove操作
     */
    public static void testGetAndPut(Ignite ignite) {
        System.out.println("\n***********************   测试Ignite的缓存   *************************");
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache1");
        for (int i = 0; i < 10; i++) {
            cache.put(i, Integer.toString(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
        }
        for (int i = 0; i < 10; i++) {
            cache.remove(i);
        }
    }

    /**
     * @Author：HeQingsong
     * @Date：14:01 2018/9/16
     * @Param [ignite, s]
     * @Return void
     * @Description：测试缓存的原子操作，在创建缓存时，需要设置支持原子操作
     */
    public static void testAtomicOperation(Ignite ignite) {
        System.out.println("\n***********************   测试Ignite缓存的原子操作   *************************");
        CacheConfiguration config = new CacheConfiguration();
        config.setName("myCache2");
        config.setAtomicityMode(CacheAtomicityMode.ATOMIC);
        IgniteCache<String, Integer> cache = ignite.getOrCreateCache(config);
        // 1、测试getAndPutIfAbsent
        //    如果这个key在缓存中没有，就执行put语句，将指定的值赋上，并返回null
        //    如果这个key在缓存中有，就执行get语句，获取原先的值，注意，这里不执行put语句，将原来的值替换
        //    意思就是，如果缓存中有这个key，就获取该key的值，如果没有，就赋值。
        System.out.println("---------测试getAndPutIfAbsent---------");
        Integer oldVal = cache.getAndPutIfAbsent("Hello", 11);
        System.out.println(oldVal);
        System.out.println(cache.get("Hello"));
        oldVal = cache.getAndPutIfAbsent("Hello", 12);
        System.out.println(oldVal);
        System.out.println(cache.get("Hello"));

        // 2、测试putIfAbsent
        //    如果这个key在缓存中没有，就put，并返回true
        //    如果这个key在缓冲中有，就什么也不做，返回false
        System.out.println("---------测试putIfAbsent---------");
        boolean success = cache.putIfAbsent("World", 22);
        System.out.println(success);
        System.out.println(cache.get("World"));
        success = cache.putIfAbsent("World", 24);
        System.out.println(success);
        System.out.println(cache.get("World"));

        // 3、测试getAndReplace，
        //    如果key在缓存中没有，就不执行，并返回null
        //    如果key在缓存中有，就替换成新值，并返回替换之前的元素
        System.out.println("---------测试getAndReplace---------");
        Integer val = cache.getAndReplace("My", 11);
        System.out.println(val);
        val = cache.getAndReplace("Hello", 50);
        System.out.println("val = " + val);
        System.out.println(cache.get("Hello"));

        //4、测试replace（这里的replace是一个原子操作，中间包含了条件判断）
        //  如果key对应的值是参数2的值，就替换成参数3的值，否则不替换
        System.out.println("---------测试replace---------");
        success = cache.replace("World", 2, 44);
        System.out.println(success);
        System.out.println(cache.get("World"));

        //5、remove（这里的remove是一个原子操作，中间包含了条件判断）
        //    如果key对应的值是参数2的值，就删除，否则什么都不做
        System.out.println("---------测试remove---------");
        success = cache.remove("World", 44);
        System.out.println(success);
        System.out.println(cache.get("World"));
    }

    /**
     * @Author：HeQingsong
     * @Date：15:14 2018/9/16
     * @Param [ignite]
     * @Return void
     * @Description：测试缓存支持事务，在创建缓存时，需要设置为支持事务的模式，下例中，可以分别注释rollback和commit，来测试提交和回滚的结果。
     */
    public static void testTransaction(Ignite ignite) {
        System.out.println("\n*************************   测试Ignite的事务   *************************");
        CacheConfiguration config = new CacheConfiguration();
        config.setName("myCache3");
        config.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        IgniteCache<String, Integer> cache = ignite.getOrCreateCache(config);
        cache.put("Hello", 1);
        try (Transaction tx = ignite.transactions().txStart()) {
            Integer hello = cache.get("Hello");
            if (1 == hello) {
                cache.put("Hello", 11);
            }
            /* tx.rollback();*/
            tx.commit();
        }
        System.out.println(cache.get("Hello"));
    }

    /**
     * @Author：HeQingsong
     * @Date：15:16 2018/9/16
     * @Param [ignite]
     * @Return void
     * @Description：测试分布式锁，注意，这里的缓存需要设置为TRANSACTIONAL，不能设置为ATOMIC模式，默认为ATOMIC模式
     */
    public static void testDestributedLock(Ignite ignite) {
        System.out.println("\n*************************   测试分布式锁   *************************");
        CacheConfiguration config = new CacheConfiguration();
        config.setName("myCache4");
        config.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        IgniteCache<String, Integer> cache = ignite.getOrCreateCache(config);
        Lock lock = cache.lock("Hello");
        lock.lock();
        try {
            cache.put("Hello", 11);
            cache.put("World", 22);
        } finally {
            lock.unlock();
        }
        System.out.println(cache.get("Hello"));
        System.out.println(cache.get("World"));
    }

    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        testGetAndPut(ignite);
        testAtomicOperation(ignite);
        testTransaction(ignite);
        testDestributedLock(ignite);
        ignite.close();
    }
}
