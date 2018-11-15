package com.heqingsong.Collection

/**
 * 懒视图：就是事先创建一个名字，这个没有对应的实体，等到使用时，才会去加载（和hibernate的懒加载一样）
 */
object Demo09 {
	def main(args: Array[String]): Unit = {
		var seqView = (1 to 100).view
		var seqView2 = seqView.map(_ * 2)
		seqView2.foreach(println)
	}
}
