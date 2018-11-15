package com.heqingsong.Array

/**
 * 数组对象的内置算法
 */
object Demo06 {
	def desc(as: Array[Int]) = for (a <- as) print(a + ",")

	def main(args: Array[String]): Unit = {
		var as = new Array[Int](10)
		for (i <- 0 until 10) as(i) = i
		desc(as)
		println()

		//数组元素求和
		println("求和结果为：" + as.sum)

		//获取元素最大值最小值
		println("最大值为：" + as.max + "，最小值为：" + as.min)

		//排序
		println("排序的结果为：" + scala.util.Sorting.quickSort(as))
	}
}
