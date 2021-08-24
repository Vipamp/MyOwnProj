package com.heqingsong.Collection

/**
  * 拉链操作
  *
  * 将两个等长的数组，使用拉链操作，把其变成元素一一对应的对偶集合，可以转换成map集合
  */
object Demo05 {
    def main(args: Array[String]): Unit = {
        var keyTuple = Array("name", "age", "sex")
        var valueTuple = Array("hqs", 24, "男")
        var tuples = keyTuple.zip(valueTuple)
        for (t <- tuples) println(t)

        //将对偶集合转换成映射
        var map = tuples.toMap
        printf("name is %s, age is %d,sex is %s", map("name"), map("age"), map("sex"))
    }
}
