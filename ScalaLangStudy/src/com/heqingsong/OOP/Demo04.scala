package com.heqingsong.OOP

/**
 * 	构造函数
 */
object Demo04 {
    def main(args: Array[String]): Unit = {

        var p = new Person40()
        println(p.toString())

        var p2 = new Person40("hqs")
        println(p2.toString())

        var p3 = new Person40("hqs", 24)
        println(p3.toString())

        var p4 = new Person40("hqs", 24, "男")
        println(p4.toString())

    }

}

/**
 * 	1、主构造器：
 * 		在类名后的括号内定义，这里面定义的字段，会自动成为该对象的成员，也就是说，在这里面指定的字段，就是该类的成员属性，类里面不需要定义的
 * 		类名后面的括号内的内容起到了两个作用：A.定义该类的成员属性，B.按照这里的成员属性，作为构造器
 *
 * 	2、辅助构造器：
 * 		在类里面通过this方法创建
 *
 * 		备注：在主构造函数中，如果变量没有定义为var或者val，只要有一个方法访问，改属性自动转变为private[this]属性
 * 			如果成员属性在定义的时候没有定义为var或者val，默认为val常量
 */
class Person40(var name: String, var age: Int, var sex: String) {

    //带有指定默认值的构造函数
    def this() {
        this("", 0, "男")
    }

    def this(fname: String) {
        this(fname, 0, "男")
    }

    def this(fname: String, age: Int) {
        this(fname, age, "男")
    }

    override def toString(): String = {
        "[name:" + this.name + ";age:" + age + ";sex:" + sex + "]"
    }
}

/**
 * 推荐定义类的方法：
 * 	（1）主构造参数为空，或者括号都不写
 * 	（2）在类里面定义成员属性，并初始化，如果不需要初始化，可以写"=_"，但是不能不写
 * 	（3）无参构造可以不写
 * 	（4）写有参构造时，先调用无参构造this()
 */
class Person41() {

    var name: String = _
    var age: Int = _
    var sex: String = _

    def this(fname: String) {
        this()
        this.name = fname
        this.age = 0
        this.sex = "男"
    }

    def this(fname: String, fage: Int) {
        this()
        this.name = fname
        this.age = fage
        this.sex = "男"
    }

    def this(fname: String, fage: Int, fsex: String) {
        this()
        this.name = fname
        this.age = fage
        this.sex = fsex
    }

    override def toString(): String = {
        "[name:" + this.name + ";age:" + age + ";sex:" + sex + "]"
    }
}