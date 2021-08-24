package com.heqingsong.OOP

import scala.collection.mutable.ArrayBuffer

/**
  * 泛型类和泛型函数：和java一样，只不过java用<>表示，scala用[]表示
  */
object Demo15 {

    //泛型函数，可以脱离类，即不在类的里面定义，在非泛型类的里面可以定义泛型函数
    def getMiddle[T](a: Array[T]) = ("" + a(a.length / 2))

    def main(args: Array[String]): Unit = {
        var list = new MyList[Person15]()
        list.add(new Person15("hqs", 12))
        list.add(new Person15("hqs2", 13))
        list.add(new Person15("hqs3", 14))
        list.scan

        var mid = getMiddle(Array[Int](1, 2, 3, 4, 5))
        println("中间值是：" + mid)
    }
}

//泛型类
class MyList[T] {
    var list = new ArrayBuffer[T]()

    //泛型函数
    def add(p: T) {
        list.+=(p)
    }

    def scan = {
        for (s <- list) {
            println(s.toString())
        }
    }
}

class Person15 {
    var name: String = _
    var age: Int = _

    def this(name: String, age: Int) {
        this()
        this.name = name
        this.age = age
    }

    override def toString = "[name:" + name + ",age:" + age + "]"
}
