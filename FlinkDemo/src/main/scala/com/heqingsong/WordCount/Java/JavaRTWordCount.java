/**
 * @Author:HeQingsong
 * @Date:2018/9/9 16:28
 * @Describe： 使用Java代码测试使用Flink实时获取数据，并统计当前2秒内，单词出现的次数
 */
package com.heqingsong.WordCount.Java;


import com.heqingsong.ParamAnalysis.JavaParamsUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class JavaRTWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //1、获取执行参数，默认ip和port是“localhost”和“9000”，执行时也可以指定参数
        //命令： flink run -c com.heqingsong.FlinkDemo.WordCount.Java.JavaRTWordCount MyFlinkProj-1.0-SNAPSHOT.jar --host master --port 9000
        String host = null == JavaParamsUtils.getParams(args, "host") ? JavaParamsUtils.getParams(args, "host") : "localhost";
        String portStr = null == JavaParamsUtils.getParams(args, "port") ? JavaParamsUtils.getParams(args, "port") : "9000";

        //2、获取flink的执行参数
        DataStreamSource<String> stream = env.socketTextStream(host, Integer.parseInt(portStr));


        SingleOutputStreamOperator windowCount = ((DataStreamSource) stream).flatMap(new FlatMapFunction<String, JavaWord>() {
            @Override
            public void flatMap(String str, Collector<JavaWord> collector) throws Exception {
                String[] strs = str.split(" ");
                for (String s : strs) {
                    collector.collect(new JavaWord(s, 1));
                }
            }
        }).keyBy("word").timeWindow(Time.seconds(2), Time.seconds(1))
                .reduce(new ReduceFunction<JavaWord>() {
                    @Override
                    public JavaWord reduce(JavaWord w1, JavaWord w2) throws Exception {
                        return new JavaWord(w1.word, w1.count + w2.count);
                    }
                });
        windowCount.print().setParallelism(1);
        env.execute("JavaRTWordCount");
    }

    //为了访问权限的方便，最好都用public修饰
    public static class JavaWord {
        public String word;
        public int count;

        public JavaWord() {
        }

        public JavaWord(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "JavaWord{" + "word='" + word + '\'' + ", count=" + count + '}';
        }
    }
}

