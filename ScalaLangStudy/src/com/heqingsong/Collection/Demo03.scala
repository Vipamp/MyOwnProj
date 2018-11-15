package com.heqingsong.Collection

/**
 * scala中Map和java中Map的互操作
 */

object Demo03 {
	def main(args: Array[String]): Unit = {
		/**
		 * java中的Map转换为scala的Map
		 * 	（1）导入包：scala.collection.JavaConversions.mapAsJavaMap
		 * 	（2）
		 */
		import scala.collection.JavaConversions.mapAsJavaConcurrentMap
		var javaMap = new java.util.HashMap[String, Any]();
		javaMap.put("name", "hqs")
		javaMap.put("age", 12)
		javaMap.put("sex", "男")
		println(javaMap.toString())

	}
}
