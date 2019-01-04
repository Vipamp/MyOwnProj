/**
 * File: IgniteUtilsTest1.java 　　2018/11/9 19:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.test;

import com.heqingsong.IgniteUtils.IgniteORM.AbstractPojoModel;
import com.heqingsong.IgniteUtils.IgniteORM.CachePool;
import com.heqingsong.IgniteUtils.IgniteTestModel.Classes;
import com.heqingsong.IgniteUtils.IgniteTestModel.Student;
import org.apache.ignite.IgniteCache;

public class IgniteUtilsTest1 {
    private static CachePool cachePool = CachePool.initAndGetCachePool();
    private static IgniteCache<String, AbstractPojoModel> classesIgniteCache = null;
    private static IgniteCache<String, AbstractPojoModel> studentIgniteCache = null;
    private static Classes classes = new Classes();
    private static Student student = new Student();

    public static void init() {
        classesIgniteCache = cachePool.getOrPushIgniteCache(Classes.class);
        studentIgniteCache = cachePool.getOrPushIgniteCache(Student.class);
    }

    /**
     * 测试可以通过get和put的方法，从ignite中读写数据
     */
    public static void test1() {
        classes.setId(1);
        classes.setName("HQS");
        classesIgniteCache.put(classes.keyBuilder(), classes);
        Classes tmp_classes = (Classes) classesIgniteCache.get(classes.keyBuilder());
        System.out.println(tmp_classes.toString());
    }

    /**
     * 测试直接修改对象，ignite会不会同步更新
     * 结果：不会同步更新
     */
    public static void test2() {
        classes.setName("HeQingsong");
        Classes tmp_classes = (Classes) classesIgniteCache.get(classes.keyBuilder());
        System.out.println(tmp_classes.toString());

        classesIgniteCache.put(classes.keyBuilder(), classes);
        tmp_classes = (Classes) classesIgniteCache.get(classes.keyBuilder());
        System.out.println(tmp_classes.toString());
    }

    /**
     * 测试一个对象绑定另一个对象存储在ignite中
     * 对象B绑定了对象A，如果对象A更新了，对象B不会在ignite中更新，
     */
    public static void test3() {
        student.setStuId(1);
        student.setAge(2);
        student.setName("HQS");
        student.setClasses(classes);
        studentIgniteCache.put(student.keyBuilder(), student);

        Student tmp_student = (Student) studentIgniteCache.get(student.keyBuilder());
        System.out.println(tmp_student);

        classes.setName("I am HeQingsong");
        classesIgniteCache.put(classes.keyBuilder(), classes);

        tmp_student = (Student) studentIgniteCache.get(student.keyBuilder());
        System.out.println(tmp_student);

        studentIgniteCache.put(student.keyBuilder(), student);
        tmp_student = (Student) studentIgniteCache.get(student.keyBuilder());
        System.out.println(tmp_student);
    }

    /**
     * 清空cache pool 中的IgniteCache对象，并关闭ignite连接
     *
     * @return : void
     * @author：HeQingsong
     */
    private static void stop() {
        classesIgniteCache.close();
        studentIgniteCache.close();
        cachePool.close();
    }

    public static void main(String[] args) {
        init();
        test1();
        test2();
        test3();
        stop();
    }
}
