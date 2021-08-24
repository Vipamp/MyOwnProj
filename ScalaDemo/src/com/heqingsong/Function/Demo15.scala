package com.heqingsong.Function

/**
  * 控制抽象：这是一种设计模式，对于没有参数没有返回值的只有一个抽象方法的接口（特质），
  * 在调用方法时，可以直接把多个函数传给这个接口，编译器自动把这些函数当做接口抽象函数内的实现，从而调用该函数
  * 这种方法比java中的装饰器模式实现简单
  */

import java.lang.Thread

object Demo15 {

    /**
      * 给一个方法传递一个函数，让这个函数在线程里面运行
      */
    def runThreadBlock(block: => Unit) { //括号可以不写
        new Thread() {
            override def run {
                block
            }
        }.start()
    }

    def main(args: Array[String]): Unit = {
        def runFun() = {
            Thread.sleep(1000)
            println("Thread1:Hello")
        }

        runThreadBlock(runFun) //普通的调用情况
        runThreadBlock {
            Thread.sleep(1000);
            println("Thread2:Hello")
        } //普通的调用情况
    }
}
