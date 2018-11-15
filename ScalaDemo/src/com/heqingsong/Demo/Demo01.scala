package com.heqingsong.Demo

object Demo01 {

	//阶乘
	def classMul(n: Int): Int = if (n == 1) 1 else n * classMul(n - 1)

	//多数字求和，使用可变长参数
	def sumN(s: Int*) = {
		var sum = 0
		for (i <- s) {
			sum += i
		}
		sum
	}

	def main(args: Array[String]): Unit = {
		println("5的阶乘为：" + classMul(5))
		println("1,2,3,3,4,5求和结果为：" + sumN(1, 2, 3, 3, 4, 5))
		println("1,2,1,2求和结果为：" + sumN(1, 2, 1, 2))
	}
}
