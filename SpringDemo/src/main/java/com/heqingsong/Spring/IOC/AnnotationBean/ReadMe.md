# 基于注解的方式，实现依赖注入

## 1、在类定义时，加上注解：
    @Component
    @Controller
    @Service
   
## 2、在xml配置文件中，加上 context 命名空间，并指定扫描的包
    context:component-scan属性参数：
        base-package: 指定待扫描的包（必须）
        resource-pattern: 只扫描该包下某子包的class文件，格式: <子包名>/*.class
    context:component-scan的子标签：
        <>

## 3、IOC会自动扫描指定的包下的类，如果该类被以上的三个注解修饰，IOC 就会创建该类的bean对象，放在 IOC容器中管理
   bean对象的默认名称，就是该类的驼峰命令方式，即第一个单词首字母小写，后面单词首字母大写。
   如果需要自定义 bean 名称，可以在注解中通过value指定，
   

### _和在xml中通过 配置 bean创建对象的区别是，基于注解的方式，创建bean对象，不需要在xml中一个一个配置，直接在对应的类定义时，加上上面的三个注解修饰即可。

