package com.heqingsong.Array

import Array._

/**
  * 多维数组
  */
object Demo3 {
    def main(args: Array[String]): Unit = {
        //创建一个一维数组
        var myMatrix1 = ofDim[Int](3)
        for (i <- 0 to 2) {
            myMatrix1(i) = i
        }
        for (i <- 0 to 2) {
            print(i + " ")
        }

        //创建一个二维数组
        var myMatrix2 = ofDim[Int](3, 3)
        for (i <- 0 to 2; j <- 0 to 2) {
            myMatrix2(i)(j) = j
        }
        for (i <- 0 to 2) {
            for (j <- 0 to 2) {
                print(" " + myMatrix2(i)(j))
            }
            println("")
        }

        //创建一个三维数组
        var myMatrix3 = ofDim[Int](3, 3, 3)
        for (i <- 0 to 2; j <- 0 to 2; k <- 0 to 2) {
            myMatrix3(i)(j)(k) = k;
        }
        for (i <- 0 to 2; j <- 0 to 2; k <- 0 to 2) {
            print(" " + myMatrix3(i)(j)(k));
        }
        println("");
        //打印数组的维度
        print(myMatrix3.size)
    }
}
