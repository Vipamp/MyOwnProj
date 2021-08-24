package com.heqingsong.OOP

import scala.beans.BeanProperty

/**
  * 为了scala的对象和get/set方法和java兼容
  * （1）导入包：import scala.beans.BeanProperty
  * （2）在需要生成javabean类型方法的属性上，加上注解：@BeanProperty，并给该属性赋初始值
  * （3）被注解的属性，会自动生成getXXX和setXXX的方法，和javabean的规范一样
  *
  */
object Demo03 {
    def main(args: Array[String]): Unit = {
        var p = new Person03
        p.setName("HeQingsong")
        p.setAge(12)
        p.setSex("男")

        println(p.toString())
    }
}

class Person03 {
    @BeanProperty var name: String = _
    @BeanProperty var age: Int = _
    @BeanProperty var sex: String = _

    //override：重写
    override def toString(): String = {
        "[name:" + this.name + ";age:" + age + ";sex:" + sex + "]"
    }
}