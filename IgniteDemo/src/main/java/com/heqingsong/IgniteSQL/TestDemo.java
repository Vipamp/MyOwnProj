/**
 * File: TestDemo.java 　　2018/10/30 22:02
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * ignite has two method to use, the first one is to use put/get operator to save object with specific key to cache,
 * another one is to use sql language to put/get object to cache. You can mixed use these two method.
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteSQL;

import com.heqingsong.IgniteUtils.IgnitionBuilder.IGNITETYPE;
import com.heqingsong.IgniteUtils.IgnitionBuilder.IgniteUtils;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.junit.Test;

import java.util.List;

public class TestDemo {
    private static Ignite ignite = null;
    private static CacheConfiguration<Integer, Classes> classCacheCfg = new CacheConfiguration<Integer, Classes>();
    private static CacheConfiguration<Integer, Student> stuCacheCfg = new CacheConfiguration<Integer, Student>();
    private static IgniteCache<Integer, Classes> classCache;
    private static IgniteCache<Integer, Student> stuCache;

    private static void initTable() {
        System.out.println("\n*************************   initialize ignite   ********************************");
        classCacheCfg.setName("CLA");
        classCacheCfg.setCacheMode(CacheMode.PARTITIONED);
        classCacheCfg.setIndexedTypes(Integer.class, Classes.class);
        classCache = ignite.getOrCreateCache(classCacheCfg);

        stuCacheCfg.setName("STU");
        stuCacheCfg.setCacheMode(CacheMode.PARTITIONED);
        stuCacheCfg.setIndexedTypes(Integer.class, Student.class);
        System.out.println(stuCacheCfg.getSqlSchema());
        stuCache = ignite.getOrCreateCache(stuCacheCfg);
    }

    /**
     * @Author：HeQingsong
     * @MethodName：insertToTable
     * @Date：19:08 2018/9/23
     * @Param：[]
     * @Return：void
     * @Description：向缓存表中插入数据，可以使用put方法，插入记录，也可以使用sql语句的方式插入数据
     */
    private static void insertToTable() {
        System.out.println("\n************************   通过put和sql语句，向ignite表中插入数据   ********************************");
        classCache.put(1, new Classes(1, "五年级一班"));
        classCache.put(2, new Classes(2, "五年级二班"));
        SqlFieldsQuery sql = new SqlFieldsQuery("insert into classes(_key,_val) values(?,?)");
        sql.setArgs(3, new Classes(3, "五年级四班"));
        classCache.query(sql);

        stuCache.put(1, new Student(1, "张三", 10));
        stuCache.put(2, new Student(1, "李四", 11));
        stuCache.put(3, new Student(2, "王五", 11));
        stuCache.put(4, new Student(2, "胜七", 10));
        SqlFieldsQuery sql2 = new SqlFieldsQuery("insert into student(_key,_val) values(?,?)");
        sql2.setArgs(5, new Student(3, "赵六", 25));
        stuCache.query(sql2);
        selectFromTable();
    }

    /**
     * @Author：HeQingsong
     * @MethodName：updateTable
     * @Date：17:26 2018/9/25
     * @Param：[]
     * @Return：void
     * @Description：执行update语句，测试删除，sql语句可以使用？作为占位符。
     */
    public static void updateTable() {
        System.out.println("\n************************   测试使用update语句，修改ignite的数据   ********************************");
        SqlFieldsQuery sql1 = new SqlFieldsQuery("update classes set name=? where id = 3");
        sql1.setArgs("\"五年级三班\"");
        classCache.query(sql1);

        SqlFieldsQuery sql2 = new SqlFieldsQuery("update student set age = age + ?");
        sql2.setArgs("2");
        stuCache.query(sql2);
        selectFromTable();
    }

    /**
     * @Author：HeQingsong
     * @MethodName：singleTableSQL
     * @Date：15:53 2018/9/23
     * @Param：[]
     * @Return：void
     * @Description：单表查询测试
     */
    public static void selectFromTable() {
        SqlFieldsQuery classSql = new SqlFieldsQuery("select * from classes");
        FieldsQueryCursor<List<?>> classQuery = classCache.query(classSql);
        for (List<?> row : classQuery) {
            System.out.print(row + "   ");
        }
        System.out.println();

        SqlFieldsQuery stuSql = new SqlFieldsQuery("select * from student");
        FieldsQueryCursor<List<?>> stuQuery = stuCache.query(stuSql);
        for (List<?> row : stuQuery) {
            System.out.print(row + "   ");
        }
        System.out.println();
    }

    /**
     * @Author：HeQingsong
     * @MethodName：multiTbaleJoin
     * @Date：16:47 2018/9/23
     * @Param：[]
     * @Return：void
     * @Description：测试多表关联查询
     */
    public static void multiTbaleJoin() {
        System.out.println("\n*************************   测试多表关联查询   ********************************");
        // 多表关联时，需要跨缓存查询，在写sql语句时，需要通过“缓存名称.表名”作为查询的表名，否则报错找不到表
        SqlFieldsQuery sql = new SqlFieldsQuery("select cls.id,cls.name,stu.classId,stu.name,stu.age " +
                "from CLA.Classes as cls left join STU.Student as stu " +
                "on cls.id = stu.classid");
        FieldsQueryCursor<List<?>> query = stuCache.query(sql);
        for (List<?> row : query) {
            System.out.println(row);
        }
    }

    /**
     * @Author：HeQingsong
     * @MethodName：aggrFunction
     * @Date：16:51 2018/9/23
     * @Param：[]
     * @Return：void
     * @Description：测试聚合函数
     */
    public static void aggrFunction() {
        System.out.println("\n*************************   测试聚合函数   ********************************");
        SqlFieldsQuery sql = new SqlFieldsQuery("select classid,avg(age),sum(age) from student group by classid");
        FieldsQueryCursor<List<?>> query = stuCache.query(sql);
        for (List<?> row : query) {
            System.out.println(row);
        }
    }

    /**
     * @Author：HeQingsong
     * @MethodName：deleteRecordFromTable
     * @Date：17:27 2018/9/25
     * @Param：[]
     * @Return：void
     * @Description：执行删除语句，从ignite表中删除数据，可以使用？作为占位符
     */
    public static void deleteRecordFromTable() {
        System.out.println("*************************   测试删除数据   ********************************");
        SqlFieldsQuery sql = new SqlFieldsQuery("delete from classes where id = ?");
        sql.setArgs("3");
        classCache.query(sql);

        SqlFieldsQuery sql2 = new SqlFieldsQuery("delete from student where classId = ?");
        sql2.setArgs("2");
        stuCache.query(sql2);
        selectFromTable();
    }

    public static void test(IGNITETYPE igniteType) {
        ignite = IgniteUtils.getIgniteInstance();
//        initTable();
//        insertToTable();
//        updateTable();
//        multiTbaleJoin();
//        aggrFunction();
//        deleteRecordFromTable();
//        selectFromTable();
        ignite.close();
    }

    public static void main(String[] args) {
        ignite = IgniteUtils.getIgniteInstance();
        initTable();
    }
}
