package com.heqingsong.Basic

/**
 * 常量和变量:</br>
 * 	var：定义变量，可以指定数据类型，也可以不指定，scala可以自动类型推断</br>
 * 		<code>var s1=1;var s2:Int=2</code></br>
 *  val：定义常量</br>
 *  	<code>val s1=1;val s2:Int=2</code></br>
 */
object Demo03 {
	def main(args: Array[String]): Unit = {
		//1、使用var定义变量，可以不指定数据类型，scala可以自动推断
		var s = 1

		//2、手动指定变量的数据类型，并赋值
		var str: String = "Hello Scala！"

		//3、定义常量
		val count = 5

		//4、变量可以重新赋值，但是不允许修改该变量原有的数据类型
		s = 3
		println(s + "\t" + str)

		//5、可以一次给多个变量赋相同的值
		val s1, s2 = 10
		println(s1 + "\t" + s2)

		//6、可以定义元组
		val tuple = (120, "120")
		println(tuple)

		//定义懒加载常量，不能定义懒加载变量，该变量在使用时才会初始化，常用来读取文件
		lazy val lv = 1
		println(lv)
	}
}

