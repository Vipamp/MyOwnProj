package com.heqingsong.Function

/**
 * 闭包：
 * 	一种特殊的函数，函数的参数是普通的参数，返回值是一个和这个参数相关的函数
 *  下次调用这个返回的函数时，原先获取的这个函数的参数被保存，新新函数中可以获取到
 *
 *  闭包不是新的特性，是高阶函数的特殊使用
 *
 */
object Demo13 {

    def mulBy(factor: Double) = (x: Double) => factor * x

    def main(args: Array[String]): Unit = {

        var mulByFun = mulBy(2) //返回的mulByFun是一个函数，(x:Int) => 2*x
        var mulByFun2 = mulBy(3) //返回的mulByFun是一个函数，(x:Int) => 3*x

        var s1 = mulByFun(4)
        var s2 = mulByFun2(5)
        println("s1:" + s1)
        println("s2:" + s2)
    }
}