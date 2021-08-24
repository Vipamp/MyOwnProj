package com.heqingsong.OOP

/**
  * object类：
  * object也可以定义类，是一种final类
  * 里面的成员和方法是静态方法
  *
  * 说白了，object类就是final类型的静态class类，可以直接使用类名获取其成员变量和方法，或者可以把object类理解为一个单例对象
  */
object Demo06 {
    def main(args: Array[String]): Unit = {
        println(ObjectTest.name)
        ObjectTest.sayHello()
    }
}

/**
  * 定义object类：ObjectTest：
  * （1）该类编译的字节码转换成java代码，是final class ObjectTest
  * （2）没有带参数的构造函数
  * （3）所有的变量和方法都是静态的，翻译成java，加了static关键词
  * （4）主要就是用来写工具类的
  *
  */
object ObjectTest {
    var name: String = "ObjectTest"

    def sayHello() {
        println("Hello World!")
    }
}