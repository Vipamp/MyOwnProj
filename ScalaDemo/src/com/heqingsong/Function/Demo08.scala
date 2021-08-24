package com.heqingsong.Function

/**
  * 高阶函数：把函数当成参数
  *
  * 函数型参数：是一种接收函数的参数，即把函数当做对象用来传参
  * 函数型参数的数据类型：(函数的输出参数列表) => 返回值
  *
  * 例如：def add(a:Int,b:Int) = a+b
  * 函数的输入参数是(Int,Int)类型，返回值是Int类型
  * var  myadd = add _	//函数名后面必须加上空格_，表示是将这个函数赋给变量，否则编译器当成调用函数，把结果赋值给变量
  * 这时候myadd变量就是一个函数型变量，其数据类型为：(Int,Int) => Int
  *
  * 函数型变量的数据类型是不确定的，由该变量 可代表函数的 形参类型和返回值确定的
  *
  */

object Demo08 {

    /*
     * 定义一个带函数型变量的函数
     * 	参数列表的写法和普通函数的写法没什么区别，只是函数型参数的数据类型，用该函数的输入输出的数据类型决定
     * 	该函数有三个参数：
     * 		f	：	(Int, Int) => (Int)		//方法体中，可以用f当做传递的函数去调用，函数类型就是参数类型
     * 		a,b	：	Int
     */
    def op(f: (Int, Int) => (Int), a: Int, b: Int) = f(a, b)

    //创建两个函数，加法和减法，输入参数是(Int,Int)，输出参数为Int
    def add(a: Int, b: Int): Int = a + b

    def sub(a: Int, b: Int): Int = a - b

    def main(args: Array[String]): Unit = {
        //将函数赋值给变量，函数名后面必须加上空格_，表示是将这个函数赋给变量，否则编译器当成调用函数，把结果赋值给变量
        var addFunc = add _
        var subFunc = sub _

        println("a+b=" + op(addFunc, 1, 2)) //将已经定义的函数，当做参数传递
        println("a-b=" + op(subFunc, 1, 2))
        println("a+b=" + op((a, b) => a + b, 1, 2)) //直接定义匿名函数当参数传递
        println("a-b=" + op((a, b) => a - b, 1, 2))
        println("a+b=" + op(_ + _, 1, 2)) //函数很简单，直接使用参数描述成表达式，当做匿名函数传递，这种方式在写spark中常用
        println("a-b=" + op(_ - _, 1, 2))

    }
}

