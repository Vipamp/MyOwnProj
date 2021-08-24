package com.heqingsong.Function

/**
  * 定义带默认参数的函数
  *
  * （1）可以在函数的参数列表中定义参数的默认值
  * （2）在调用函数时，如果不指定参数名，默认是按照顺序一一对应，如果指定了参数名，按照参数名=变量值来
  */
object Demo04 {

    def sum(a: Int = 1, b: Int = 2, c: String = "Hello"): Int = {
        print(c + ":")
        a + b
    }

    def main(args: Array[String]): Unit = {
        println("默认值相加结果为：" + sum())
        println("3 + 4 = " + sum(3, 4))
        //如果前面参数保持默认，后面的参数不默认，需要使用命名指定形参
        println("a=3,b默认，结果为： " + sum(3, c = "sdf"))
        println("b=3,a默认，结果为： " + sum(b = 3, c = "sdf"))
    }
}
