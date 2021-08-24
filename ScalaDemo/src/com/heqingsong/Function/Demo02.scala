package com.heqingsong.Function

/**
  * 函数的传值调用和传名调用：
  * （1）传值调用：先将函数A计算好，获取函数A的结果，再将结果当参数调用函数B（常用的函数调用方式）
  * （2）传名调用：暂时不计算好函数A的值，将函数A名当参数传递到函数B，如果函数B用到了该参数，再调用函数A（类似于C语言的函数指针，将函数当参数，用到了才调用）
  *
  */
object Demo02 {
    def main(args: Array[String]) {
        delayed1(time) //传名
        println()
        delayed2(time()) //传值
    }

    def time(): Long = {
        println("获取时间，单位为纳秒")
        return System.nanoTime
    }

    /**
      * 传名调用：将time()函数当做变量t，返回值类型为Long，用到了t，再去调用time()函数
      */
    def delayed1(t: () => Long) = {
        println("在 delayed1 方法内")
        println("参数： " + t()) //调用delayed1函数时，传递的参数是time，这里t()就是去调用time()这个函数
    }

    /**
      * 传值调用：将先计算time()的值，返函数结果，把劫夺方参数调用delayed2函数
      */
    def delayed2(t: Long) = {
        println("在 delayed2 方法内")
        println("参数： " + t)
    }
}
