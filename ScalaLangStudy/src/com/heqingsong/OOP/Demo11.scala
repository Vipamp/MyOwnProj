package com.heqingsong.OOP

/**
 * 匿名子类
 */
object Demo11 {
	def main(args: Array[String]): Unit = {
		var chinese = new Person11("hqs", 24, "男") { //在类后加上调用父类的构造方法，构造子类对象
			var country = "China"
			var language = "chinese"
			override def desc = super.desc + ",country:" + country + ",language:" + language
		}
		println(chinese.desc)
	}
}

class Person11() {
	var name: String = _
	var age: Int = _
	var sex: String = _

	def this(fname: String, fage: Int, fsex: String) {
		this()
		this.name = fname
		this.age = age
		this.sex = fsex
	}
	def desc = "name:" + name + ",age:" + age + ",sex:" + sex
}
