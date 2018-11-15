package com.heqingsong.Basic

/**
 * scala语法规范</br>
 * 		（1）区分大小写 -  Scala是大小写敏感的，这意味着标识Hello 和 hello在Scala中会有不同的含义。</br>
 * 		（2）类名 - 对于所有的类名的第一个字母要大写。</br>
 * 		（3）方法名称 - 所有的方法名称的第一个字母用小写。</br>
 * 		（4）程序文件名 - 程序文件的名称应该与对象名称完全匹配。</br>
 * 		（5）方法：def main(args: Array[String])是scala的强制程序入口</br>
 *
 * 注释：	和java一样，//是单行注释，/**/是多行注释</br>
 *
 * 一句结束，用不用分号结束都可以，如果多句写在一行，必须要分号</br>
 *
 * 使用package定义包，使用import导入包，没有规定必须在文件头部导入包</br>
 * 	（1）导入scala的包：直接使用import 加上包名，例如：import math._等同于import scala.math._
 * 	（2）导入java的包：需要指定使用java的包：例如：import java.math._
 * 	_等同于java包的*通配符
 */

import scala.io.StdIn
import scala.math._
object Demo01 {
	def main(args: Array[String]) {
		println("Hello, world!")
		println("Hello, world!")
		println(Pi)
		println(sqrt(2)) //调用scala的sqrt方法
		println(Math.sqrt(2)) //调用java包的sqrt方法

		//控制台的输入
		var inputStr = StdIn.readLine("请输入字符串")
		println("您输入的字符串为：" + inputStr)

		//控制台的输出
		print("这个是不换行输出")
		println("这个是换行输出")
		printf("这个是格式化输出，你输入的字符串为:%s", inputStr)
	}
}
