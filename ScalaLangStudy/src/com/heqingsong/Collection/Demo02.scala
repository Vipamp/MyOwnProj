package com.heqingsong.Collection

import scala.collection.JavaConverters._

/**
 * Map映射：
 *
 */
object Demo02 {
	def main(args: Array[String]): Unit = {
		//1、创建一个Map映射（不可变Map），编译器自动判断Map键值对的泛型类型
		var map = scala.collection.immutable.Map("name" -> "hqs", "sex" -> "男")
		printf("name is %s,sex is %s\n", map("name"), map("sex")) //通过映射键，获取映射值，或者使用map.get(key)的方式获取
		map += "age" -> "24"
		println("age:" + map("age"))
		map += "age" -> "25"	//使用+=操作符，不能使用对偶的方式增加了，只能使用键值对方式，map+=("age","25")这种方式不可以
		println("age:" + map("age"))

		//2、创建一个可变Map，并初始化键值对
		//TODO 备注：不可变Map里面没有put方法， 可变里面有，但是不可变Map可以通过+=添加键值对，不知道不可变指哪里？？？？
		var map2 = scala.collection.mutable.Map("name" -> "hqs", "sex" -> "男")
		printf("name is %s,sex is %s\n", map2("name"), map2("sex")) //通过映射键，获取映射值
		map2 += ("age" -> "24")
		println("age:" + map2("age"))
		map2 += ("age" -> "25")
		println("age:" + map2("age"))
		map2.put("school", "HFUU")
		println(map2("school"))

		//3、创建空键值对的可变Map		
		var map3 = scala.collection.mutable.Map[String, Any]()
		map3.put("name", "hqs")
		map3.put("age", 12)
		map3.put("sex", "男")
		map3.put("school", "HFUU")
		println(map3.mkString("  "))

		//4、对偶：就是键值对
		var t1 = "name" -> "hqs"
		var t2 = ("sex", "男") //在scala中，这两种对偶的写法都可以，第一种是键值对的写法，第二种是元组的写法
		var map4 = scala.collection.mutable.Map[String, Any]()
		//Map就是对偶的集合
		map4 += t1
		map4 += t2
		//map4 += (t1, t2) //+=可以同时增加多个对偶
		printf("name is %s,sex is %s\n", map4.get("name"), map4.get("sex"))
		printf("name is %s,sex is %s\n", map4("name"), map4("sex"))

		//获取元素
		println("map4的name是" + map4.get("name")) //使用get获取元素
		println("map4的name是" + map4.apply("name")) //使用apply获取元素
		println("map4的name是" + map4("name")) //调用apply的简写

		//getOrElse如果获取不到，给一个默认值返回，或者用applyOrElse也可以，上面三种，获取不到会报错
		println("map4的age是" + map4.getOrElse("age", 0))

		//5、修改
		map4 += ("name" -> "hqs2") //直接使用+=，如果有相同的key，会自动覆盖
		map4("sex") = "女" //直接通过键获取原来的值，覆盖掉
		println(map4.mkString("  "))

		//6、删除键值对
		map4 -= "sex" //通过key删除键值对
		println(map4.mkString("  "))

		//7、按照键值对的方式遍历Map：以下两种，都是遍历Map，一种是直接变成(k,v)对，一种是得到kv对的对象
		for ((k, v) <- map3) println(k + " --> " + v)
		for (t <- map3) println(t)

		//8、只获取键，或者只获取值 的遍历方法（和java一样）
		var keys = map3.keySet
		println("所有的键为：" + keys.mkString(","))
		var values = map3.values
		println("所有的值为：" + values.mkString(","))
	}
}
