/**
 * @ClassName：Class
 * @Author：HeQingsong
 * @Date：2018/9/23 15:23
 * @Since：JDK1.8
 * @Version：1.0
 * @Description： 定义Ignite中的班级类，指定字段，
 * @QuerySqlField注解，表示该字段是Ignite可识别字段，不加上该注解，Ignite不识别，index = true 表示在该字段上加上索引
 */
package com.heqingsong.IgniteUtils.IgniteTestModel;

import com.heqingsong.IgniteUtils.IgniteORM.AbstractPojoModel;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.HashMap;
import java.util.Map;

public class Classes extends AbstractPojoModel<Classes> {
    private static final String CACHE_NAME = "CLASSES";

    private class COLUMNS {
        private static final String ID = "id";
        private static final String NAME = "name";
    }

    @QuerySqlField
    private int id;

    @QuerySqlField
    private String name;

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


    @Override
    public String toString() {
        return "Classes{" + "id=" + id + ", name='" + name + '\'' + "}";
    }

    @Override
    public String keyBuilder() {
        return String.valueOf(this.id);
    }

    @Override
    public Classes mapToObject(Map<String, Object> map) {
        Classes classes = new Classes();
        classes.setId((Integer) (map.get(COLUMNS.ID)));
        classes.setName((String) map.get(COLUMNS.NAME));
        return classes;
    }

    @Override
    public Map<String, Object> objectToMap(Classes classes) {
        Map<String, Object> map = new HashMap<>(10);
        map.put(COLUMNS.ID, String.valueOf(classes.getId()));
        map.put(COLUMNS.NAME, String.valueOf(classes.getName()));
        return map;
    }

    @Override
    public String getCacheName() {
        return Classes.CACHE_NAME;
    }
}
