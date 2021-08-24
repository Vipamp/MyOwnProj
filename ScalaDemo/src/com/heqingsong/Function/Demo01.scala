package com.heqingsong.Function

/**
  * 定义函数：
  * 格式：def functionName ([参数列表]) : (返回值类型) = {
  * function body
  * return [expr]
  * }
  * 参数列表：	先写形参名，后写参数类型，中间使用冒号，如果多个参数，使用逗号隔开
  * 返回值类型：	如果有返回值，写返回值类型，如果没有返回值，写Unit（类似于java中的void）
  *
  * 方法和函数的区别：
  * 方法是针对对象的，和类相关，指的是对象的函数，需要通过类或者对象调用
  * 函数，是和类不相关的，不受对象限制，可以直接调用
  *
  * scala同时支持函数和方法
  *
  */
object Demo01 {
    def main(args: Array[String]): Unit = {
        println("1 + 2 = " + sum(1, 2))
        println("-3的绝对值为：" + abs(-3))
        println("5的阶乘为：" + classMul(5))
        process
        process2
    }

    def sum(a: Int, b: Int): Int = {
        return a + b
        //也可以直接写a+b,return可以省略 ，函数体的最后一个表达式就是函数的返回值
    }

    def sum2(a: Int, b: Int): Int = a + b

    def abs(a: Int) = if (a > 0) a else -a

    //求阶乘的递归函数，如果是递归，函数的返回值类型必须加上，其他函数的返回值类型可以不加，编译器可以自动推断
    def classMul(n: Int): Int = if (n == 1) 1 else n * classMul(n - 1)

    //过程，是一种特殊的函数，没有返回值，定义函数时没有等于号，就算return返回值，也没有用，函数的调用结果为Unit
    def process() {
        println("Hello World!")
    }

    def process2() {
        println("Hello World!")
    }
}
