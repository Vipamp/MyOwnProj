package com.heqingsong.Basic

/**
 * 数据类型</br>
 * Byte		8位有符号补码整数。数值区间为 -128 到 127</br>
 * Short	16位有符号补码整数。数值区间为 -32768 到 32767</br>
 * Int		32位有符号补码整数。数值区间为 -2147483648 到 2147483647</br>
 * Long		64位有符号补码整数。数值区间为 -9223372036854775808 到 9223372036854775807</br>
 * Float	32位IEEE754单精度浮点数</br>
 * Double	64位IEEE754单精度浮点数</br>
 * Char		16位无符号Unicode字符, 区间值为 U+0000 到 U+FFFF</br>
 * String	字符序列</br>
 * Boolean	true或false</br>
 * Unit		表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。</br>
 * Null		null 或空引用</br>
 * Nothing	Nothing类型在Scala的类层级的最低端；它是任何其他类型的子类型。</br>
 * Any		Any是所有其他类的超类，等同于java的Object，是AnyRef和AnyVal的基类</br>
 * AnyRef	AnyRef类是Scala里所有引用类(reference class)的基类</br>
 * AnyVal	AnyVal类是Scala里所有基本数据类型类(String、Int等)的基类</br>
 *
 * 每一个数据类型，都是一个类，即严格来讲，scala没有基本数据类型，以上的数据类型都类似于java包装类
 * 即每一个变量，都是对象，可以调用方法
 *
 * scala除了支持以上的数据类型之外，还支持java的数据类型，但是要指定java.lang包
 * 例如：var s:java.lang.Integer = 1;
 */
object Demo02 {
	def main(args: Array[String]): Unit = {

		//scala自己的基本数据类型
		var i1 = 10
		println(i1)
		var s1 = "2"
		println(i1)

		//Int转换成String
		var s2 = i1 + ""
		var s3 = i1.toString //i是Int对象，可以调用toString方法，如果方法没有参数，括号可以不写

		//String类型转换为Int类型，scala的数据类型可以和java的数据类型混用，也可以直接用toInt()
		var i2 = java.lang.Integer.parseInt(s1)		//使用java的方式处理
		println(i2 + 1)
		println(s1.toInt+1)		//使用scala的基本数据类的转换方法

		//支持java的数据类型
		var i3: java.lang.Integer = 1
		var s4: java.lang.String = "1"

		//Int和浮点数的转换
		var d1 = i1.toDouble //如果方法没有参数，括号可以不写
		println(d1)
		var d2: Double = 123.345
		println(d2.toInt) //如果方法没有参数，括号可以不写

		//BigInt，可以当做普通的数据类型做运算操作
		var bi: BigInt = 1234567890
		println(bi * bi)
	}
}
