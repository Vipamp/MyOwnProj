package com.heqingsong.Basic

/**
 * 循环语句
 * 	补充: 1 to/until 10 表示产生一个list，to不是for循环内的语法，是产生list的语法
 * 例如: a = 1 to 10
 */

object Demo06 {

	//循环语句遍历数组的高级操作，详见：com.heqingsong.Array.Demo05
	def main(args: Array[String]): Unit = {
		//1、while循环，和java一样
		var s = 10
		while (s > 0) {
			print(s + " ")
			s = s - 1
		}
		println()

		//2、do-while循环，和java一样
		s = 10
		do {
			print(s + " ")
			s = s - 1
		} while (s > 0)
		println()

		//3、for循环:
		//格式：for ( i <- list)
		//1 to 10是包含1和10 ，1 until 10是包含1，不包含10
		//scala没有for(;;)这种格式的for循环，直接使用<-增强for循环，且迭代变量不需要定义类型
		//java 的增强for循环：for(Sring s:strList)
		//scala的增强for循环：for(s <- strList)
		var i = 0
		for (i <- 1 to 10) { //等价于：for(i <- 1.to(10))
			print(i + " ")
		}
		println()
		for (i <- 1 until 10) { //等价于：for(i <- 1.until(10))
			print(i + " ")
		}
		println()

		//4、多重循环：在for内，使用；分割各循环条件，即将多个条件都循环一次，构成笛卡尔积的循环效果，类似于嵌套循环
		var a, b, c = 0
		for (a <- 1 to 3; b <- 1 to 3; c <- 1 to 4) {
			println("Value of a: " + a)
			println("Value of b: " + b)
			println("Value of c: " + c)
			println()
		}

		//效果同上
		for (a <- 1 to 3) {
			for (b <- 1 to 3) {
				for (c <- 1 to 4) {
					println("Value of a: " + a)
					println("Value of b: " + b)
					println("Value of c: " + c)
					println()
				}
			}
		}

		//5、循环集合
		var list = List(1, 3, 5, 7, 9) //使用List()方法创建集合
		for (x <- list) {
			print(x + " ")
		}
		println()

		//6、循环过滤，每一个条件，都有一个过滤，这个叫做守卫条件
		//例如：x <- list if x > 5 ;y <- list2 if y > 10
		list = List(1, 2, 3, 4, 5, 6, 7, 8, 9) //使用List()方法创建集合
		for (x <- list if x > 5) { //如果有多个条件，可以用for (x <- list if x > 5; if x < 9) {
			print(x + " ")
		}
		println()

		//7、for使用 yield创建list
		//yield的意思是，将for遍历出来的集合元素，按照yield后面的表达式处理，生成一个新的集合
		var retVal = for (a <- list if a > 6; if a < 9 ) yield a * 2
		for (a <- retVal) {
			println("Value of a: " + a)
		}

		//8、循环退出：scala没有break或者continue关键字，
		//需要导入scala.util.control.Breaks._的包，调用break()方法，()可以省略，直接写break
		//但是这个方法抛异常
		import scala.util.control.Breaks._
		for (i <- 1 to 10) {
			println(i)
			if (i == 5) {
				break
			}
		}
	}
}
