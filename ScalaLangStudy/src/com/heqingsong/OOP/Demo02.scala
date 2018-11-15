package com.heqingsong.OOP

/**
 * 	this关键字和private[xxx]
 * 		（1）this关键字：和java一样，指调用方法的对象本身
 * 		（2）private[this]修饰的属性，只能被this对象自己访问，其他的同类对象不嗯给你访问
 * 			private修饰的属性，同类对象可以相互访问该属性，该属性有get方法
 * 			private[this]修饰的属性，同类对象不可以相互访问该属性，该属性没有get方法
 * 		（3）private[类名]	：指定哪几个类可以访问这个对象的该属性
 */
object Demo02 {
    def main(args: Array[String]): Unit = {

    }
}

class Person {
    private var age = 0
    def equals(p: Person) = this.age == p.age
}

class Person2 {
    private[this] var age = 0
    def equals(p: Person2): Boolean = {
        //this.age == p.age    //age被定义成了private[this],所以在方法中，被传递的对象p的age属性，不能被访问
        false
    }
}

class Person3 {
    private[Person3] var age = 0
    def equals(p: Person3): Boolean = {
        this.age == p.age //age被定义成了private[this],所以在方法中，被传递的对象p的age属性，不能被访问
        false
    }
}