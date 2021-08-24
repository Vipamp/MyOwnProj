package com.heqingsong.Basic

/**
  * 模式匹配：说白了，就是java的switch语句</br>
  * java的模式匹配：</br>
  * <code>
  * switch(a){</br>
  * case 1:...;beeak</br>
  * case 2:...;beeak</br>
  * case 3:...;beeak</br>
  * default:</br>
  * }</br>
  * </code>
  *
  * scala的模式匹配：</br>
  * <code>
  * a match {</br>
  * case 1 => xxx</br>
  * case 2 => xxx</br>
  * case 3 => xxx</br>
  * case _ => xxx</br>
  * }</br>
  * </code>
  *
  */
object Demo08 {
    def main(args: Array[String]): Unit = {
        var a = 4

        //1、查看a是匹配哪个case的分支，结果为true，就执行 => 后面的语句
        //2、一个分支后，不需要加上break，执行完，不会跳到下一个分支
        //3、剩下的分支，使用通配符_表示，等同于java的default
        //4、case后可以使用表达式或者函数判断（守卫），其结果是True或者False，备注：在if前，需要加上通配符_
        a match {
            case 1 => println("a的值是1")
            case 2 => println("a的值是2")
            case 3 => println("a的值是" + a) //在=>后，是可以使用被匹配参数的
            case _ if (a - 4 == 0) => println("a的值是" + a) //守卫条件
            case _ => println("a的值大于4")
        }

        //4、match的结果可以带返回值
        var result = a match {
            case 1 => "1"
            case 2 => "2"
            case 3 => "3"
            case 4 => "4"
            case _ => ">4"
        }
        println("result is " + result)

        //5、支持字符串的模式匹配
        var s = "abc"
        s match {
            case "abc" => println("这是abc")
            case _ => println("这不是abc")
        }

        //6、类型的模式匹配，比如在多态中，父类指向子类对象，现在需要判断该对象的实际类型，
        var obj: Any = "string"
        obj match {
            case x: String => println("这是一个字符串")
            case x: Int => println("这是一个整数")
            case x: Map[String, Int] => println("这是一个[String,Int]泛型的Map") //不要使用泛型做匹配，这种是不靠谱的
            case x: Map[_, _] => println("这是一个[_,_]泛型的Map") //如果需要匹配，不要加上泛型
        }

        //7、正则表达式匹配
        var pattern = "([0-9]+) ([a-z]+)".r
        "99 pattern" match {
            case pattern(num, item) => println("num:" + num + ",item:" + item)
            case _ => println("匹配失败")
        }
    }
}

