package com.heqingsong.Function

/**
  * 函数的可变长参数：
  * （1）在定义函数的新参的数据类型时，将数据类型加上*
  * （2）如果函数除了可变参数，还可以传递形参，将形参写在前面，可变长参数写在后面
  * （3）在调用参数时，前面的参数时一一对应的，后面没有对应的参数，放在可变长参数变量中
  * （4）一个函数，只能指定一个可变长参数，不能设置两个可变长参数，数据类型不同的也不行
  * （5）可变长参数，在函数中是常量的集合，只读，不能修改其值
  *
  */
object Demo03 {
    //定义数据类型不同的可变长参数
    def text1(s: String, nums: Int*) {
        print(s)
        for (num <- nums) {
            print(num + " ")
        }
        println()
    }

    //定义数据类型相同的可变长参数
    def text2(s: Int, nums: Int*) {
        print(s)
        for (num <- nums) {
            print(num + " ")
        }
        println()
    }

    def main(args: Array[String]): Unit = {
        text1("num:", 1, 2, 3, 4, 5)
        text1("num:", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        text2(1, 2, 3, 4, 5)
        text2(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        //text2(1 to 10)		//这种方式不可以
        //text2是可变长参数，1 to 10 的结果是一个序列对象，而不是多个参数，_*是告诉编译器，这个序列当参数序列使用
        //这种方式，只能将序列对应给可变参数，不能拆分一个参数给前面的单个参数
        text2(1, 1 to 10: _*)
    }
}
