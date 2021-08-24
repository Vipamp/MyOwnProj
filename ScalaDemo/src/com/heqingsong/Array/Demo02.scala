package com.heqingsong.Array

/**
  * 变长数组：
  * （1）导入包：import scala.collection.mutable.ArrayBuffer
  * （2）创建ArrayBuffer对象
  * （3）使用+=追加元素
  * （4）使用++=追加集合内的元素
  */

import scala.collection.mutable.ArrayBuffer

object Demo02 {
    def main(args: Array[String]): Unit = {
        var ab = new ArrayBuffer[Int]() //new可省略
        ab += 1 //追加元素，直接使用+=添加元素，也可以使用append追加元素
        ab.append(2)
        ab += 3
        ab += (4, 5, 6) //这种方式可以追加多个元素
        ab ++= Array(7, 8, 9) //这种方式追加集合
        println(ab)

        //从前或者后移除n个元素
        ab.trimEnd(3)
        ab.trimStart(3)
        println(ab)

        //指定位置插入元素
        ab.insert(1, 10)
        ab.insert(2, 11, 12, 13) //在指定位置插入多个元素，自动向后迭代插入
        println(ab)

        //指定位置移除元素
        ab.remove(1, 4) //第一个参数是移除元素的开始索引，第二个参数是向后移除元素的个数
        println(ab)

        //获取变长数组的长度
        println("此时数组的长度为：" + ab.size)

        var as = ab.toArray //将变长数组转换为定长数组
        for (i <- as) print(i + ",")
        println()

        var ab2 = as.toBuffer //将定长数组转变为变长数组
        ab2.append(7, 8, 9)
        println(ab2)
    }
}
