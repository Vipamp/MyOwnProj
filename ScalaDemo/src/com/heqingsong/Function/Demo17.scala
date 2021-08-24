package com.heqingsong.Function

/**
  * 隐式参数
  */
object Demo17 {

    //带有隐式参数的函数，可以当做隐式参数的可以是：基本数据类型，对象实例，函数
    def desc(str: String)(implicit dec: Decorate) {
        println(dec.left + str + dec.right)
    }

    def test1 = {
        //定义一个隐式值，备注：这个隐式值可以是常量，也可以是变量，但是定义变量没啥用，反正改了后的也用不了
        implicit val dec = new Decorate("<<< ", " >>>")
        //在调用带有隐式参数的函数时，隐式参数可以不传，编译器自动会将之前定义好的隐式值当参数传递，调用隐式函数
        //这样做的好处，是在调用函数时，每次调用时，不需要传递相同的参数
        desc("Hello World!")
        desc("I am HeQingsong!")
        desc("I like Scala")
    }

    //使用函数当做隐式参数
    def descFun(a: Int, b: Int)(implicit func: (Int, Int) => Int): Int = {
        func(a, b)
    }

    def test2 = {
        implicit val addFun = (a: Int, b: Int) => a + b
        println("1+2 = " + descFun(1, 2))
    }

    def main(args: Array[String]): Unit = {
        test1
        test2
    }
}

class Decorate(var left: String, var right: String) {}
