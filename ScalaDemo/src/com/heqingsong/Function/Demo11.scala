package com.heqingsong.Function

/**
  * map:按照map函数指定的逻辑（可以给匿名函数），处理list的每个元素，产生新的list,_是通配符，表示每个元素，例如：(1 to 10).map(2*_)	#结果：2,4,6,8,10...
  * filter:给定一个判断语句，将判断结果为true的元素值取出来
  * foreach:给定一个函数，按照函数的逻辑，将各元素当做函数参数，指定该函数逻辑
  */
object Demo11 {

    def main(args: Array[String]): Unit = {
        var as = Array(1, 2, 3, 4, 5)
        println("as:" + as.mkString(","))

        //map方法是，遍历list里面的每一个元素，并按照给定的函数规则处理各元素，得到一个新的list返回
        //里面传递的参数是一个函数：_*2 的等同于：(x)=>x*2
        var asMap = as.map(_ * 2)
        var asMap2 = as.map((x) => x * 2)
        println("asMap:" + asMap.mkString(","))
        println("asMap2:" + asMap2.mkString(","))

        //foreach方法是，遍历list的每一个元素，并按照给定的方法处理该元素
        //可以查看foreach的源码，实际上就是对每一个元素，执行一次传递的方法
        //备注：foreach参数指定的方法没有返回值，就算加了返回值，也没有用，foreach底层没有返回
        asMap.foreach(println _)
        asMap.foreach(x => println("这个元素是" + x)) //效果相同

        //使用函数链打印三角形
        (1 to 9).map(2 * _).filter(_ < 10).map("*" * _).foreach(x => println(x + "," + x.length()))
    }
}

