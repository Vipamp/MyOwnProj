package com.heqingsong.Exception

object Demo02 {

    def div(a: Int, b: Int) = {
        if (b == 0) {
            //手动抛异常，这个和java一样
            throw new ArithmeticException("除数不能为0")
        } else {
            a / b
        }
    }

    def main(args: Array[String]): Unit = {
        println("10/2的结果是：" + div(10, 2))
        println("10/0的结果是：" + div(10, 0))
    }
}
