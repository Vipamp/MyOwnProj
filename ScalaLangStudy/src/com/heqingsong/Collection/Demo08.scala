package com.heqingsong.Collection

import scala.collection.mutable.LinkedHashSet
import scala.collection.mutable.SortedSet

/**
 * Set集合：不可重复，无序
 *
 */
object Demo08 {
	def main(args: Array[String]): Unit = {

		//1、Set不按照使用者的数据处理先后排序，默认按照hashcode来排序的，所以对于使用者来说，Set是不可重复、无序的元素集
		//这样，从Set中查找元素，速度会快很多，比Array、List、ArrayBuffer等都快
		var set = Set(1, 5, 3, 6, 4, 2)
		println(set.mkString(","))

		//2、链式哈希集，这个不会打乱顺序，是通过链表来维护这个顺序的
		var hashSet = LinkedHashSet(1, 5, 3, 6, 4, 2)
		hashSet+=7
		println(hashSet.mkString(","))

		//3、排序Set，等同于java的HashSet，是按照值的hash值排序
		var sortedSet = SortedSet(1, 5, 3, 6, 7, 2)
		sortedSet+=4
		println(sortedSet.mkString(","))
	}
}
