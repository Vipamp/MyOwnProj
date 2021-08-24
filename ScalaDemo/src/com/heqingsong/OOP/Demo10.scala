package com.heqingsong.OOP

/**
  * 继承类的构造函数
  */
object Demo10 {

}

class Person10(var name: String, var age: Int, var sex: String) {

    def desc = "name:" + name + ",age:" + age + ",sex:" + sex
}

/**
  * 子类继承父类，如果父类有主构造方法，子类必须要有，在子类的构造方法中，重新定义新的成员属性名称，父类后，要调用父类的构造方法
  * 即定义一个子类的主构造方法，再调用父类的构造方法，传递参数，所以父类括号里的属性，在子类的主构造方法中必须要有
  */
class Chinese10(var fname: String, var fage: Int, var fsex: String,
                var country: String, language: String) extends Person10(fname, fage, fsex) {

    //使用override关键字，重写父类方法
    override def desc = {
        //可以使用super关键词调用父类的方法
        super.desc + ",country:" + country + ",language:" + language
    }
}
