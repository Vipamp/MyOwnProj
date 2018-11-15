package com.heqingsong.Collection

object Demo06 {

	def main(args: Array[String]): Unit = {
		var x = (1, 2, 3, 4, 5)
		var (a, b, c, d, e) = x
		println("a=" + a + ",b=" + b + ",=" + c + ",d=" + d + ",e=" + e)
	}
}
