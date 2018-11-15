package com.heqingsong.Exception

/**
 * 	抛异常表达式
 */
object Demo04 {

	def div(a: Int, b: Int) = {
		var y = if (b != 0) a / b else throw new ArithmeticException("除数不能为0")
		y
	}

	def main(args: Array[String]): Unit = {
		var s: Any = ""
		try {
			var s = div(10, 2)
			println("10/2的结果是：" + s)
			s = div(10, 0)
			println("10/0的结果是：" + s)
		} catch {
			case e: Exception => println(e)
		}
	}
}
