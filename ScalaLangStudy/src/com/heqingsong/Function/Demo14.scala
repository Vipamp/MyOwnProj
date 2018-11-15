package com.heqingsong.Function

/**
 * 函数柯里化：
 * 		两个参数的函数，变成一个参数的函数，返回值是以第二个参数作为参数的函数
 */
object Demo14 {

	//直接写两个参数作为函数的参数列表
	def add(a: Int, b: Int) = a + b
	//将参数拆开，add2(a: Int)可以理解成一个返回函数的函数
	def add2(a: Int)(b: Int) = a + b

	//add2等同于add3
	def add3(a: Int) = (b: Int) => a + b

	def main(args: Array[String]): Unit = {
		//1、直接使用两个参数获取变量
		var s = add(1, 2)
		println(2)

		//2、使用柯里化的方式调用函数
		var a1 = add2(1) _ //add2(1)的返回值，是一个函数，该函数的参数是(b:Int) => 1+b
		var a2 = a1(2) //调用函数a1，即(b:Int) => 1+b。
		println(a2)

		//3、柯里化函数的本质
		var add3Fun = add3(1)
		var a3 = add3Fun(2)
		println(a3)

		var a4 = add3(1)(2)
		println(a4)
	}
}
