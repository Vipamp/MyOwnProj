package com.heqingsong.Collection

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.LinkedList

/**
 * Seq：有先后次序的序列
 * 		这里的有先后次序，不是指按照某一个规则排序
 *
 * （1）数组：详见com.heqingsong.Array
 * （2）列表：List:不可变，基于链表实现的，LinkedList，可变链表
 * （3）向量：vector：ArrayBuffer的不可变版本，一个带下标的序列，支持快速随机访问，但是其数据访问速度没有ArrayBuffer快
 */
object Demo07 {

	//测试Vector向量
	def testVactor() {
		var vector = Vector(1, 2, 3, 4, 5)
		println(vector.mkString(","))
		println("第一个元素是：" + vector(0))

		//测试Vector和ArrayBuffer的访问速度
		var sumAll = 0
		var vectorTest = Vector((1 to 10000000): _*) //这里使用_*，是将1 to 100转换成一个个的元素，放在vector里面

		var startTime = new java.util.Date().getTime
		for (i <- 0 to 9999999) {
			sumAll = sumAll + vectorTest(i)
		}
		var endTime = new java.util.Date().getTime
		println("使用vector一共花费了：" + (endTime - startTime))

		sumAll = 0
		var arrayTest = new ArrayBuffer[Int]()
		for (i <- 1 to 10000000) {
			arrayTest += i
		}
		startTime = new java.util.Date().getTime
		for (i <- 0 to 9999999) {
			sumAll = sumAll + arrayTest(i)
		}
		endTime = new java.util.Date().getTime
		println("使用ArrayBuffer一共花费了：" + (endTime - startTime))
	}

	//测试：List，list是基于链表实现的，不支持随机访问，其元素的访问速度较慢
	def testList() {
		//不可变链表
		var list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println("list的第一个元素是：" + list.head + ",后面的元素是:" + list.tail.mkString(","))
		println("list的第一个元素是：" + list(0))
		//迭代的方式遍历链表
		var cur = list
		while (cur != Nil && cur.head != null) { //Nil表示是一个空链表
			print(cur.head + ",")
			cur = cur.tail
		}

		//可变链表：
		var linkedList = LinkedList(1, 2, 3, 4, 5)
		println("\nlist的第一个元素是：" + linkedList.head + ",后面的元素是:" + linkedList.tail.mkString(","))
		println("list的第一个元素是：" + linkedList(0))
	}

	def main(args: Array[String]): Unit = {
		testVactor
		testList
	}
}
