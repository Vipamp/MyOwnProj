package com.heqingsong.Basic

/**
 * 条件语句：和java一模一样
 *
 * 	另：条件表达式
 *
 */
object Demo05 {

	def main(args: Array[String]): Unit = {

		var x = 2
		//条件表达式
		var s = if (x > 1) 1 else 2 //如果x>1，s=1，否则s=2，返回值是Int类型
		var s2 = if (x > 1) 1 else "2" //也可以是不同的数据类型，返回值是Any类型
		var s3 = if (x > 1) 1 else () //如果x>1,s3=1，否则什么也不干，()是无有用值的占位符
		var s4 = if (x > 1) 1 //同上，()就是等同于空值，Unit类型，和void类似

		//1、一般的if - else if - else
		if (s > 0) {
			print("s > 0")
		} else if (s < 0) {
			print("s < 0")
		} else {
			print("s = 0")
		}

		//2、if嵌套
		if (s > 0) {
			print("s > 0")
		} else {
			if (s < 0) {
				print("s < 0")
			} else {
				print("s = 0")
			}
		}
	}
}
