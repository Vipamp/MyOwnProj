package com.heqingsong.Basic

/**
 * 操作符
 */
object Demo07 {

	def main(args: Array[String]): Unit = {
		//1、中置操作符：操作符在中间
		var i1 = 1 to 10 //实际上是调用了to方法：1.to(10) 产生1,2,3,4,5....10的序列
		var i2 = 1 + 6 //实际上是调用了+方法：1.+(6)
		var i3 = 1 -> 10 //实际上是调用了->方法：1.->(10),产生一个元组（1,10）

		//2、一元操作符：只有一个参数，符号在前称为后置操作符，在前称为前置操作符
		var i4 = 1 toString //实际上是调用了toString方法：1.toString
		var i = 5
		var i5 = -i //实际上是调用了unary_-方法，如果是+i，调用的是方法unary_+

		/*
		 * 操作符的结合性
		 * （1）默认的都是左结合
		 * （2）：结尾的是右结合
		 * （3）=也是右结合
		 */
		var is = 1 :: 2 :: 3 :: Nil //构造一个数组：中间使用::分割，最后加上Nil表示结尾
		println("is的类型是：" + is.getClass + "，内容是：[" + is.mkString(",") + "]")
	}
}
