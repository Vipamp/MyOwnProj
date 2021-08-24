package com.heqingsong.Function

/**
  * 隐式转换
  */
object Demo16 {
    //测试将分数转换成小数
    def testFra2Double {
        implicit def Fraction2Double(f: Fraction): Double = {
            println("将" + f.out() + "转换成小数")
            f.top / f.bottom
        }

        var f = new Fraction(2, 3)
        println("5/f = " + 5 / f)
    }

    //测试将整数转换成分数
    def testInt2Fraction {
        //隐式转换：使用implicit关键字定义隐式转换函数，自动可以将int类型转换为Fraction类型
        //函数名可以随便取，位置也可以随便放，只要函数能找到就可以了，通常，把隐式转换函数放在类的伴生对象中
        //java和scala可以相互调用，主要是依赖于大量的隐式转换函数
        var f = new Fraction(3, 4)

        implicit def int2Fraction(n: Int) = { //只带有单个参数
            println("将" + n + "转换成分数 " + n + "/1")
            new Fraction(n, 1)
        }

        println(3 * f) //这里调用时，会自动调用隐式转换函数，将3转换成Fraction类的对象，再*f2
    }

    def main(args: Array[String]): Unit = {
        var f1 = new Fraction(1, 2)
        var f2 = new Fraction(3, 4)
        println(f1 * f2)
        //println(3 * f2)		//如果使用3 * f2这样是错误的，因为这个*是Fraction类的方法，3是Int类型的
        testFra2Double
        testInt2Fraction
    }
}

//定义一个分数类
class Fraction(var top: Int, var bottom: Int) {
    def out() {
        println(top + "/" + bottom)
    }

    def *(f: Fraction) = top * f.top + "/" + bottom * f.bottom
}
