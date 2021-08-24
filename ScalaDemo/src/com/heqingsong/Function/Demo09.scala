package com.heqingsong.Function

/**
  * 高阶函数：将函数作为返回值
  *
  */
object Demo09 {
    def add(a: Int, b: Int) = a + b

    def sub(a: Int, b: Int) = a - b

    //返回一个已存在的函数
    def getFunc(n: Int) = if (n > 0) add _ else sub _

    //函数的另外一种写法：参数列表  => 函数体或者函数返回值表达式
    //(a: Int, b: Int) => a + b  就可以表示一个两个数相加的匿名函数（函数，说白了，就是输入输出的映射关系）
    def getAddFunc = (a: Int, b: Int) => a + b

    def main(args: Array[String]): Unit = {
        println("调用+法，参数是1,2，结果是：", getFunc(1)(1, 2))
        println("调用-法，参数是1,2，结果是：", getFunc(-1)(1, 2))

        var addFunc = getAddFunc //获取一个加法函数，函数的类型是：（Int,Int） => Int
        var s = addFunc(2, 4)
        println("2 + 4　的结果是：" + s)
    }
}