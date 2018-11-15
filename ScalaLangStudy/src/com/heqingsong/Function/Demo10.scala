package com.heqingsong.Function

/**
  * 匿名函数
  */
object Demo10 {

    def cal(f: (Int, Int) => Int, a: Int, b: Int): Int = f( a, b )

    def main(args: Array[String]): Unit = {
        println( "将匿名函数当做参数传递", cal( (a: Int, b: Int) => a + b, 1, 2 ) )
        println( "将匿名函数当做参数传递", cal( (a: Int, b: Int) => a - b, 1, 2 ) )
        println( "将匿名函数当做参数传递", cal( _ + _, 1, 2 ) ) //直接使用_+_，表示将两个数相加
        println( "将匿名函数当做参数传递", cal( _ - _, 1, 2 ) )

        //甚至可以这么写，自定义一个匿名函数，再调用该匿名函数
        println( ((x: Int) => (2 * x)) ( 3 ) )
        //println( (2 * _) ( 3 ) ) //这种方式不可以的
    }
}