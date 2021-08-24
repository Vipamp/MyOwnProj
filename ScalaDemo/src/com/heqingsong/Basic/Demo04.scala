package com.heqingsong.Basic

/**
  * scala运算符：（和java一样）
  * +、-、*、/		加、减、乘、整除	（不支持++ 、--等操作，但是有+=等）
  * /%				除法，这个的结果是一个对偶，坐标是b/a的值，右边是b%a的值，备注：b必须是BigInt类型
  * %				取余
  * >、<、>=、<=		大于、小于、大于等于、小于等于
  * ==				等于
  * !=				不等于
  * &&				逻辑与
  * ||				逻辑或
  * !				逻辑非
  **/
object Demo04 {
    def main(args: Array[String]): Unit = {
        var a = 10
        var b = 20
        var c = 25
        var d = 25
        println("a + b = " + (a + b))
        println("a - b = " + (a - b))
        println("a * b = " + (a * b))
        println("b / a = " + (b / a))
        println("c / a = " + (c / a))
        println("c % a = " + (c % a))
        println("c /% a = " + (BigInt(c) /% a))

        //+运算符重载，+可以为基本运算符，同时在Int类中，也有一个方法为+，实现了操作符重载
        println(a + b)
        println(a.+(b))

        //下面的三个效果一样，都是按照索引，取字符串的某个字符
        println("hello".apply(4))
        println("hello" (4))
        println("hello".charAt(4))
    }
}
