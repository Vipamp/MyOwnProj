package com.heqingsong.Function

/**
 * 内嵌函数
 * 		（1）可以在函数A内部再定义子函数B和C，此时A、B、C三个函数可以相互调用（可以递归调用，注意死循环导致堆栈溢出）
 * 		（2）函数A外的函数，只能调用函数A，调用不了A内部的函数B、C
 */
object Demo05 {
	def sum(a: Int, b: Int): Int = {
		//定义内嵌函数
		def sum0(a: Int, b: Int): Int = {
			return sum1(a, b)
		}
		def sum1(a: Int, b: Int): Int = {
			return a + b
		}
		return sum0(a, b)
	}

	def main(args: Array[String]): Unit = {
		print("1 + 2 = " + sum(1, 2))
	}
}
