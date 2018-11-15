package com.heqingsong.OOP

/**
 * 抽象类
 */
object Demo12 {
	def main(args: Array[String]): Unit = {
		var chinese = new Chinese12()
		chinese.desc
		chinese.speak //子类对象可以调用父类方法
	}
}

/**
 * 抽象类中，可以有非抽象的方法，也可以有抽象方法
 * 如果类中有抽象方法（没有方法体），则该类必须是抽象类，需要加上abstract关键词
 * 规则和java一样
 */
abstract class Person12 {
	def desc
	def speak = println("I am Person")
}

class Chinese12 extends Person12 {
	//子类必须重写父类的抽象方法，非抽象方法可以重写可以不重写，子类重写抽象方法，可以不加override
	def desc = println("I am Chinese")
}
