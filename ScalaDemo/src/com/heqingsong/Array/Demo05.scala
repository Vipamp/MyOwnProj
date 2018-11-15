package com.heqingsong.Array

/**
 * 数组高级操作
 */
object Demo05 {

	//遍历数组
	def main(args: Array[String]): Unit = {
		var as = new Array[Int](10)
		for (i <- 0 until 10) as(i) = i
		//mkString可以将数组转换成字符串遍历输出，并且可以指定开始结束符和元素分隔符
		println(as.mkString("<", ",", ">"))

		//1、步长遍历数组
		for (i <- 1 until (10, 2)) print(i + ",")
		println()

		//2、反向遍历
		for (i <- (1 until (10, 2)).reverse) print(i + ",")
		println()

		//3、数组转换，将for循环遍历，使用yield后面的表达式，处理各个元素，得到一个新的集合
		var as2 = for (i <- 1 until 10) yield i * 2
		println(as2.mkString("<", ",", ">"))

		//4、数组元素过滤和处理（重要，在spark很多这种写法）
		//将as数组能被2整除的元素取出来，再乘以2，_为元素的通配符，编写scala更倾向于这种写法，比yield好用
		var b = as.filter(_ % 2 == 0) //使用filter过滤元素，结果产生一个新的集合，原来的集合元素内容不变
		println(as.mkString(","))
		println(b.mkString(","))
		var b2 = b.map(2 * _) //使用map处理元素
		println(b.mkString("<", ",", ">"))
		println(b2.mkString("<", ",", ">"))
	}
}
