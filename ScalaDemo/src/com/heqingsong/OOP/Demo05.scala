package com.heqingsong.OOP

import scala.collection.mutable.ArrayBuffer

object Demo05 {
    def main(args: Array[String]): Unit = {
        var country = new Country()
        country.addProvince("安徽", "福建", "江苏", "浙江", "江西")
        country.showAllProvince
    }
}

/**
  * 内部类
  */
class Country {
    var name: String = _
    var ps = new ArrayBuffer[Province]()

    class Province {
        var name: String = _

        def this(fname: String) {
            this()
            this.name = fname
        }

        override def toString: String = "[name:" + name + "]"
    }

    def addProvince(p: String*) {
        for (pname <- p) {
            ps += new Province(pname)
        }
    }

    def showAllProvince = {
        for (p <- ps) println(p.toString())
    }
}