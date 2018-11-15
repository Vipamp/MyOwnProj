/**
  * Author：HeQingsong
  * Time：2018/9/9 15:49
  * Description：
  * 批处理做WordCount
  */
package com.heqingsong.WordCount.Scala

import org.apache.flink.api.scala.ExecutionEnvironment

object ScalaBatchWordCount {

    case class Word(word: String, count: Int)

    def main(args: Array[String]) {

        //1、获取批处理的运行环境，这里是用ExecutionEnvironment类，流处理的运行环境，是用StreamExecutionEnvironment获取运行环境的。
        val env = ExecutionEnvironment.getExecutionEnvironment

        //2、从本地读取文件
        val text = env.readTextFile("C:\\readme.txt")

        //3、单词统计 //需要使用隐式转换，否则调用flatMap会报错
        val counts = text.flatMap(w => w.split(" ")) //切割单词后压扁
          .filter(_.nonEmpty)
          .map(_ => new Word(_, 1))
          .groupBy("word")
          .sum("count")

        //4、输出结果，可以设置并行度，如果是1，就生成一个文件，如果是n（大于1），result就为目录名，在该目录下创建n个文件，每一个都是对应并行度输出的结果
        counts.writeAsCsv("D:\\result", "\n", " ==> ").setParallelism(1)

        //5、执行job操作
        env.execute("Scala Batch WordCount Example") //这个必须要加上，否则不会启动该Job任务
    }
}
