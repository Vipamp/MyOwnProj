/**
  * Author：HeQingsong
  * Time：2018/9/9 15:49
  * Description：
  * 测试使用Flink实时获取数据，并统计当前2秒内，单词出现的次数
  */
package com.heqingsong.WordCount.Scala

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

object ScalaRTWordCount {

    case class Word(word: String, count: Int)

    def main(args: Array[String]) {
        //1、获取运行时环境
        val env = StreamExecutionEnvironment.getExecutionEnvironment

        //2、指定端口，从socket中获取数据
        val text = env.socketTextStream("localhost", 9000, '\n')

        //3、单词统计
        import org.apache.flink.api.scala._ //需要使用隐式转换，否则调用flatMap会报错
        val counts = text.flatMap(w => w.split(" ")) //切割单词后压扁
          .map(Word(_, 1)) //将每个单词，创建一个对象
          .keyBy("word") //按照对象的word属性分组
          .timeWindow(Time.seconds(2), Time.seconds(1)) //设置时间窗口，第一个参数是滑块长度，第二个参数是时间间隔
          //          .reduce((a, b) => Word(a.word, a.value + b.value))            //聚合汇总
          .sum("count")

        //4、输出结果
        counts.print().setParallelism(1)

        //5、指定代码，注意，如果不执行execute方法，这个job是不会提交到flink上执行的，因为flink是采用懒加载模式的。
        env.execute("Scala WordCount Example") //这个必须要加上，否则不会启动该Job任务
    }
}
