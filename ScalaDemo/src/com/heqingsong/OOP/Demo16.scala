package com.heqingsong.OOP

import scala.collection.mutable.ArrayBuffer

/**
 * 泛型的变量类型限定
 */
object Demo16 {

	def main(args: Array[String]): Unit = {
		//var list = new MyList2[Int]    //Int不是AnyRef的子类，不能使用Int作为类MyList2的泛型        
		var list2 = new MyList2[Person16]
	}
}

//限定类型的泛型类，这里的T被限定为AnyRef的子类，即只有AnyRef的子类才可以使用该泛型类
// T <: className    表示上界，T要是className类或者他的子类，
// T >: className    表示下界，T要是className类或者他的父类，
// T >: className1 <: className2    多重界定，表示T是className2的子类，className1的父类
// T <% className    表示T可以被隐含转换成className类
class MyList2[T <: AnyRef] {
	var list = new ArrayBuffer[T]()

	//泛型函数
	def add(p: T) = list.+=(p)

	def scan = for (s <- list) {
		println(s.toString())
	}
}

class Person16(name: String, age: Int) {
	override def toString = "[name:" + name + ",age:" + age + "]"
}
