package com.heqingsong.OOP

/**
  * 特质（和java的接口一样，抽象类的更深层次抽象）
  */
object Demo13 {
    def main(args: Array[String]): Unit = {
        var chinese = new Chinese13
        chinese.desc
        chinese.speak

        var american = new American13
        american.desc
        american.speak

        //可以在创建对象时带接口，并实现接口的方法
        var japan = new Japan with Person13 with Speakable {
            override def desc = println("I am Japanese")

            def speak = println("I speak Japanese")
        }
        japan.desc
        japan.speak
    }
}

trait Person13 { //特质翻译成字节码，转换为java，就是用interface定义的接口，里面可以有抽象方法和具体方法
    def desc = println("我是人") //具体方法，在翻译成class文件，变成了静态方法
}

trait Speakable { //特质翻译成字节码，转换为java，就是用interface定义的接口，里面可以有抽象方法和具体方法
    def speak; //	抽象方法
}

class Chinese13 extends Person13 with Speakable { //类实现特质也是用extends，一个类可以实现多个特质，中间使用with连接
    override def desc = println("I am Chinese") //重写特质的具体方法，需要加上override
def speak = println("I speak Chinese") //实现或者重写抽象方法，可以不加上override
}

class American13 extends Person13 with Speakable {
    override def desc = println("I am a American")

    def speak = println("I speak English")
}

class Japan {
}
