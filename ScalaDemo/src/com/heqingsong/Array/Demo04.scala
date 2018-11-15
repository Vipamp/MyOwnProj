package com.heqingsong.Array

import Array._
/**
 * 创建区间数组
 */
object Demo4 {
	def main(args: Array[String]): Unit = {
		var myList = range(10, 20) //获取从10到20的区间数据，生成一个数组，含头不含尾
		for (i <- myList) {
			print(i + " ")
		}
		println()
		myList = range(10, 20, 2) //获取从10到20的，步长为2的区间数据，生成一个数组
		for (i <- myList) {
			print(i + " ")
		}
		println()
	}
}
