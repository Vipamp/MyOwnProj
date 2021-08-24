package com.heqingsong.Collection

/**
  * 集合：需要重新整理
  */
object Demo01 {
    def main(args: Array[String]): Unit = {
        // 定义整型 List，有序可重复
        val list = List(1, 2, 3, 4, 4) //等同于List.apply(1,2,3,4)，还用类List的静态方法创建List集合
        for (x <- list) {
            print(x + " ")
        }
        println()

        // 定义 Set，无序不可重复
        val set = Set(1, 3, 5, 7, 7)
        for (x <- set) {
            print(x + " ")
        }
        println()

        // 定义 Map，键值对映射的集合
        // 映射关系有两种写法：使用"one" -> 1是一种表示方法，还有一种，是使用对偶（二元组）的方式表示
        val map = Map("one" -> 1, "two" -> 2, ("three", 3)) //两种方式可以混写
        //完整键值对（对偶）为元素，遍历map，这种方式，获取到的是k-v键值对的一个对偶，没有拆分key和value
        for (x <- map) {
            print(x + " ")
        }
        println()
        //拆分键值对（对偶）为元素，遍历map，这种方式，可以直接获取到对偶的key和value的值，给两个变量
        for ((a, b) <- map) {
            print(a + "--->" + b + ",")
        }
        println()

        // 创建两个不同类型元素的元组
        val tuple = (10, "Runoob")

        //List集合迭代
        var iter = list.iterator
        while (iter.hasNext) {
            print(iter.next() + ",")
        }
        println()

        //map的迭代
        var mapIter = map.iterator
        while (mapIter.hasNext) {
            print(mapIter.next() + ",")
        }
    }
}
