package com.heqingsong.OOP

/**
 * 继承、对象类型判断和模式匹配
 *
 * 		（1）p.isInstanceOf[ClassName]：判断对象p是否是类ClassName的实例对象（等同于java的：p isinstance of ClassName）
 * 		（2）p.asInstanceOf[ClassName]：将对象p强转成ClassName类的对象（等同于java的：(CLassName)p）
 * 		（3）p.getClass：				   ：获取对象p属于哪个类的类名（等同于java的：p.getClass()）
 * 		（4）ClassOf[ClassName]:		   ：获取类ClassName的类名（等同于java的：ClassName.class）
 */
object Demo09 {
	def main(args: Array[String]): Unit = {
		var p = new Person9("hqs", 24, "男")
		var chinese = new Chinese9("hqs2", 23, "男", "China", "Chinese")

		if (p.isInstanceOf[Person9]) { //判断对象p是否是Person9类的实例对象
			println(p.desc)
		}
		if (chinese.isInstanceOf[Chinese9]) {
			println(chinese.desc)
		}

		//通过对象，拿到该对象的类名
		println("对象p的类名为：" + p.getClass)

		//对象类型的模式匹配，这种形式判断对象类型，比上面的几种方法好
		p match {
			case a: Chinese9 => println("这是中国人")
			case a: Person9 => println("这是外国人")
			case _ => println("不知道什么鬼")
		}
	}
}

class Person9() {
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

class Chinese9 extends Person9 {
	//scala不支持多继承
	var country = "China"
	var language = "Chinese"

	def this(fname: String, fage: Int, fsex: String, fcountry: String, flanguage: String) {
		this()
		this.name = fname
		this.age = age
		this.sex = fsex
		this.country = fcountry
		this.language = flanguage
	}

	//使用override关键字，重写父类方法
	override def desc = {
		//可以使用super关键词调用父类的方法
		super.desc + ",country:" + country + ",language:" + language
	}
}
