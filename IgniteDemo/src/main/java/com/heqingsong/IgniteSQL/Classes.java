/**
 * @ClassName：Class
 * @Author：HeQingsong
 * @Date：2018/9/23 15:23
 * @Since：JDK1.8
 * @Version：1.0
 * @Description： 定义Ignite中的班级类，指定字段，
 * @QuerySqlField注解，表示该字段是Ignite可识别字段，不加上该注解，Ignite不识别，index = true 表示在该字段上加上索引
 */
package com.heqingsong.IgniteSQL;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Classes {
    @QuerySqlField(index = true)
    private int id;

    @QuerySqlField
    private String name;

    private int level;

    public Classes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Class [id=" + id + ", name=" + name + ", level=" + level + "]";
    }
}
