package com.heqingsong.Exception

/**
  * 使用try-catch捕获处理异常，只是在catch捕获异常的格式和java有点区别，其他的一样
  */
object Demo01 {
    def main(args: Array[String]): Unit = {
        try {
            var i1 = 10
            var i2 = 0
            var i3 = i1 / i2
        } catch {
            case e: ArithmeticException => println("除数不能为0")
            case e: NumberFormatException => println("字符串不能转换为数字")
        }

        try {
            var is = "sd"
            var i4 = is.toInt
        } catch {
            case e: NumberFormatException => println("字符串不能转换为数字")
        } finally {
            println("测试结束")
        }
    }
}
