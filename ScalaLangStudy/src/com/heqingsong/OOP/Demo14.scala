package com.heqingsong.OOP

/**
 * 特质内部指定哪些类可以继承该特质
 */
object Demo14 {

}

trait MyException {
	this: Exception => def desc = println("这个自定义异常")
}

/*
 * 	这种继承方法是错误的，特质MyException指定了Exception和其子类可以继承该特质
class MySonException extends MyException {

}*/

//想要继承MyException特质，先继承Exception类，变成他的子类，再继承MyException类
class MySonException2 extends Exception with MyException {

}
