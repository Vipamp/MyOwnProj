package com.heqingsong.Function

/**
  * reduceLeft:指定方法，应用于前两个元素，将其结果作为第一个元素，再向后遍历元素，直到遍历整个集合
  * reduceRight:指定方法，应用于后两个元素，将其结果作为最后一个元素，再向后前历元素，直到遍历整个集合
  */
object Demo12 {
    def main(args: Array[String]): Unit = {
        var s = Array( 4, 2, 6, 3, 7, 6, 4, 1, 3 )

        //等同于 ((((4+2)+6)+3)...)
        println( "s内所有元素的和是：" + s.reduceLeft( _ + _ ) )

        //等同于((((4 max 2) max 6) max 3)...)
        println( "s的最大元素是：" + s.reduceLeft( (x, y) => if(x > y) x else y ) )
        println( "s的最大元素是：" + s.reduceLeft( (x, y) => (x max y) ) ) //可以使用操作符：max/min比较大小

        //等同于((((4 min 2) min 6) min 3)...)
        println( "s的最小元素是：" + s.reduceLeft( (x, y) => if(x < y) x else y ) )
        println( "s的最小元素是：" + s.reduceLeft( (x, y) => (x min y) ) )

        //等同于((((1*2)*3)*4)*5)
        println( "5的阶乘是：" + (1 to 5).reduceLeft( _ * _ ) )
    }
}