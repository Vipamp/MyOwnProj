package com.heqingsong.OOP

object Demo01 {
    def main(args: Array[String]): Unit = {
        //使用私有成员的get/set方法
        var p = new Point
        p.setX(2)
        p.setY(3)
        printf("p的坐标为：(%d,%d)\n", p.getX, p.getY)

        //使用共有成员自带的get/set方法
        var p2 = new Point2
        p2.x_=(1) //set方法：p.属性名_=(参数)
        p2 y_= 2 //set方法： p 属性名_=参数        //这两种方法都可以，注意："属性名_="这是个方法名，=不是赋值的意思
        //p2 z_= 2 //属性z在类中定义为常量，这里不能通过z_=方法修改
        printf("p2的坐标为：(%d,%d)\n", p2.x, p2.y) //get方法
    }
}

/**
 * 定义类：
 * 		1、一个文件可以定义多个class类
 * 		2、定义类属性：
 * 			如果属性设置为private，需要自己定义get/set方法
 * 			如果属性设置为public(默认)，编译器会自动生成get/set方法，分别为"属性名"和"属性名_="
 */
class Point {
    //显示设置私有成员，自动生成的get/set方法也是私有的，需要自己重新编写get/set方法
    private var x = 0
    private var y = 0

    def getX = x
    def getY = y

    def setX(xc: Int) = { x = xc }
    def setY(yc: Int) = { y = yc }

    /**
     * 	下面的两个，是自动生成的get/set方法，如果属性指定了为private，则这get/set方法也是private
     * def x = x
     * def x_=(a: Int) = { x = a }	//这里的"x_="是方法名
     */

}

class Point2 {
    //默认设置的属性，是private修饰的，但是提供了public类型的get/set方法，可供外部调用
    var x = 0
    var y = 0
    val z = 0
}