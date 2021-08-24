package com.heqingsong.Collection

/**
  * 元组：不同类型的值的聚集
  */
object Demo04 {
    def main(args: Array[String]): Unit = {
        //新建一个元组，里面可以存放不定数量不同类型的值
        var tuple1 = (1, "hqs", "HFUU")

        //对偶是一种特殊的元组
        var t = ("name", "hqs") //或者写成	var t = "name" -> "hqs"

        //获取元组中元素的值，注意，索引从1开始
        println("tuple1的三个值分别为：" + tuple1._1 + "," + tuple1._2 + "," + tuple1._3)

        //元组通常用在函数的返回值不止一个的情况
        var intArr = Array(1, 4, 6, 2, 3, 6, 77, 93, 22, 47)
        var minmax = getMinMax(intArr)
        printf("最大值是：%d，最小值是：%d", minmax._1, minmax._2)
    }

    //给定一个Int数组，返回最大值和最小值
    def getMinMax(intArr: Array[Int]): (Int, Int) = {
        (intArr.max, intArr.min)
    }
}
