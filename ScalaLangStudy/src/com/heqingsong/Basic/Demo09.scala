package com.heqingsong.Basic

/**
 * 元组的特殊拆分方式
 */
object Demo09 {
	def main(args: Array[String]): Unit = {
		var x = (1, 2, 3, 4, 5)
		var (a, b, c, d, e) = x
		println("a=" + a + ",b=" + b + ",=" + c + ",d=" + d + ",e=" + e)
	}
}
