package com.heqingsong.Array

/**
  * 定长数组
  */
object Demo01 {
    def main(args: Array[String]): Unit = {
        //定义一个定长数组
        var strs1 = new Array[String](3) //[]是泛型
        var strs2: Array[String] = new Array[String](3)

        //直接初始化一个定长数组
        var strs3 = Array("Hello", "Scala", "!") //这个是Array.apply("Hello", "Scala", "!")的简写
        val strs4 = Array("Hello", "Scala", "!")

        //操作数组：取值：
        println("strs3(0)的元素为：" + strs3(0)) //strs(3)指的是strs.apply(3)

        //操作数组：赋值，这个调用的是strs1.update(0,"Hello")
        strs1(0) = "Hello"
        //如果是获取值，调用的是apply方法，如果是赋值，调用的是update方法
        strs1(1) = "Scala"
        strs1(2) = "!"
        println(strs1)
        println(strs1.toString())
        println("数组的长度为：" + strs1.length)

        //遍历数组
        for (str <- strs4) {
            print(str + " ")
        }

        // strs4 = new Array[String](3);//常量数组变量，只能指向这个数组，不能指向其他数组，但是其值可以改变
        strs4(1) = "World" //修改数组的值
        for (str <- strs4) {
            print(str + " ")
        }
    }
}
