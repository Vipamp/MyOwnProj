package com.heqingsong.Function

/**
  * 函数柯里化
  */
object Demo07 {
    //常用写法
    def sum(a: Int, b: Int): Int = a + b

    //柯里化写法
    def sum2(a: Int)(b: Int): Int = a + b

    //变形：拆成两个，后面的其实就是lambda表达式
    def sum3(a: Int) = (b: Int) => a + b

    //多层柯里化函数
    def sum4(a: Int) = (b: Int) => (c: Int) => (d: Int) => a + b + c + d

    def main(args: Array[String]): Unit = {
        println( "1 + 2 = " + sum( 1, 2 ) )
        println( "1 + 2 = " + sum2( 1 )( 2 ) )

        var s1 = sum3( 1 ) //返回的是一个函数
        println( "s1 = " + s1 )
        var s2 = s1( 1 )
        println( "s2 = " + s2 )
        println( sum4( 1 )( 2 )( 3 )( 4 ) )
    }
}

