package com.heqingsong.Function

/**
  * 匿名函数：
  * 使用var定义函数，其语法类似于lambda表达式
  *
  */
object Demo06 {
    //定义函数的原始写法（不怎么用）
    def inc = new Function1[Int, Int] {
        def apply(a: Int): Int = a + 1
    }

    //定义函数的第二中写法（函数逻辑较长的通用写法）
    def sum2(a: Int, b: Int): Int = {
        return a + b
    }

    //定义函数的第三种写法（逻辑较简单的通用写法）
    def sum3(a: Int, b: Int): Int = a + b

    //定义函数的第四种写法，使用var 和def 定义都可以
    //使用var定义，这是一个函数式变量，是Function的对象
    //使用def定义，这就是一个实实在在的函数了
    var sum4 = (a: Int, b: Int) => a + b

    def sum5 = (a: Int, b: Int) => a + b

    def main(args: Array[String]): Unit = {
        println("1 + 2 = " + inc(1))
        println("1 + 2 = " + sum2(1, 2))
        println("1 + 2 = " + sum3(1, 2))
        println("1 + 2 = " + sum4(1, 2))
        println("1 + 2 = " + sum5(1, 2))
    }
}
