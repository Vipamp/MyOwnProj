package com.heqingsong.OOP

/**
 * 伴生类和伴生对象
 * 		（1）在一个文件内，定义一个class类和同名的object类，如下的class Chinese和object Chinese
 * 		（2）其中的class Chinese类是object Chinese的伴生类，object Chinese是class Chinese类的伴生对象
 * 		（3）可以理解java的一个Chinese类，将其中的非静态用class Chinese定义，静态用object Chinese定义
 * 		（4）查看字节码，会发现class Chinese的内容和object Chinese的内容写在一个类中，object类中的内容全部用static修饰
 * 		（5）		var chinese1 = new Chinese		//这个获取到的是由class Chinese创建的对象
 * 				var chinese2 = Chinese			//这个获取到的是由object Chinese对应的单例对象
 *
 * 		其实，就是把java中类的静态部分和非静态部分拆开了，静态部分放在object类中，非静态部分放在class类中
 * 		object XXX可以理解为该伴生类的伴生对象，同时也理解为单例对象的工厂类，可以直接创建该单例对象
 */
object Demo07 {
    def main(args: Array[String]): Unit = {

        //创建一个伴生类的对象
        var chinese = new Chinese
        chinese.name_=("HeQingsong")
        chinese.age_=(24)
        chinese.sex_=("男")
        println(chinese.toString())
        //chinese.speakLanguage//这个是错误的，不能通过对象访问object类的成员

        //使用伴生对象（这里的伴生对象，可以理解为Chinese的静态单例类，通过类名访问）
        println("国籍：" + Chinese.country)
        Chinese.speakLanguage

        var staticChinese = Chinese //也可以直接获取到该类的单例对象，通过该单例对象访问静态属性或者方法
        println("国籍：" + staticChinese.country)
        staticChinese.speakLanguage
    }
}

class Chinese {
    var name: String = _
    var age: Int = _
    var sex: String = _

    override def toString = "{name:" + this.name + ";age:" + age + ";sex:" + sex + "}"
}

object Chinese {
    var country = "China"
    def speakLanguage = println("I speak Chinese")
}