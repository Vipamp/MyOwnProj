/** File: com.heqingsong.Spring.IOC.AnnotationBean.MyConfig 　　2019/01/03 下午5:12
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 *     使用 Configuration 创建 bean 对象，可以替代 xml 配置 bean 对象，
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.AnnotationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    /**
     * 使用bean的注解配置bean对象，通常需要自己通过name指定，bean对象的名称，默认是驼峰方法名，不是返回类的驼峰对象名
     */

    @Bean(name = "myComponent")
    public MyComponent getMyComponent() {
        return new MyComponent();
    }

    @Bean(name = "myController")
    public MyController getMyController() {
        return new MyController();
    }

    @Bean(name = "service")
    public MyService getMyService() {
        return new MyService();
    }
}
