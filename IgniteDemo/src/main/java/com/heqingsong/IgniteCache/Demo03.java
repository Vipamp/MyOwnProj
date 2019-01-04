/**
 * @ClassName：Demo03
 * @Author：HeQingsong
 * @Date：2018/9/16 16:35
 * @Since：JDK1.8
 * @Version：1.0
 * @Description： 测试Ignite的同步和异步
 * 同步：在调用带返回值的函数时，等待知道获取结果，才向下走
 * 异步：在调用带返回值的函数时，调用完，就继续想下走，可以在后面获取该函数的返回值
 */
package com.heqingsong.IgniteCache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteFuture;

public class Demo03 {
    /**
     * @Author：HeQingsong
     * @Date：16:43 2018/9/16
     * @Param [ignite]
     * @Return void
     * @Description：测试同步计算和异步计算 同步计算：调用call方法指定计算逻辑时，通过call方法返回结果，获取到结果后，才回向下继续执行
     * 异步计算：调用call方法指定计算逻辑时，不是等待其返回结果，而是主线程继续执行，
     * 指定的计算可以理解为重新开一个线程执行，主线程通过future()获取其计算结果
     */
    public static void testAsyncCompute(Ignite ignite) {
        //1、同步计算
        // 获取IgniteCompute对象，调用call方法，给其传递一个方法，运行到这里时，执行这个方法去计算，其结果通过call方法返回结果，再继续执行
        IgniteCompute compute = ignite.compute();
        String res = compute.call(() -> {
            System.out.println("Hello World");
            return "Hello World";
        });
        System.out.println("result = " + res);

        //2、异步计算
        //  IgniteCompute对象调用withAsync()方法，将其变成异步计算，调用call，传递计算方法时，可以理解成重新开启一个新线程计算call方法的内容
        // 主线程继续向下执行，异步计算代码块的返回结果，是由IgniteCompute的future()方法获得，而不像同步方法那样，直接由call返回计算结果。
        IgniteCompute icompute = ignite.compute().withAsync();
        icompute.call(() -> {
            System.out.println("Hello World 2");
            return "Hello World 2";
        });

        IgniteFuture<String> s = icompute.future();
        s.listen(f -> {
            System.out.println(f.get());
        });
    }

    /**
     * @Author：HeQingsong
     * @Date：18:04 2018/9/16
     * @Param [ignite]
     * @Return void
     * @Description：同步和异步从缓存中读数据 Ignite API中并不是每个方法都是分布式的，因此也就没必要异步化，为了避免关于哪个方法是分布式的混乱，就是哪个能异步那个不能。
     * Ignite API中的每个分布式方法都被加上了@IgniteAsyncSupported注解。
     */
    public static void testAsyncDF(Ignite ignite) {
        //1、同步读缓存
        IgniteCache<String, Integer> myCache = ignite.getOrCreateCache("myCache");
        myCache.getAndPut("key", 1);
        System.out.println(myCache.get("key"));

        //2、异步读缓存
        IgniteCache<Object, Object> asyncCache = ignite.getOrCreateCache("myCache").withAsync();
        asyncCache.getAndPut("key", 1);
        IgniteFuture<Object> f = asyncCache.future();
        f.listen(s -> System.out.println(s.get()));
    }

    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        testAsyncCompute(ignite);
        testAsyncDF(ignite);
        ignite.close();
    }
}
