package com.heqingsong.Basic

/**
 * 在scala中，可以调用par方法，这样编译器会自动将数据分配到CPU不同的核下计算， 然后再汇总起来
 */
object Demo11 {
	def main(args: Array[String]): Unit = {

		//并行求和
		var as = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("结果：" + as.par.sum)

		//并行for循环，是将for循环变量，分开到不同的CPU中运算，所以打印的结果没有固定的顺序
		for (a <- (0 to 10).par) print(a + ",")

		//
		var count = 0
		for (a <- (0 to 10).par) {
			if (a % 2 == 0) {
				//count=count+1		//备注：在并行for循环中，不允许操作以外变量，只能访问
				println(a + "count = " + count)
			}
		}
	}
}
