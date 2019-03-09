/**
 * @Author:HeQingsong
 * @Date:2018/9/11 10:29
 * @Describe： 使用java代码，测试批处理的WordCount
 */
package WordCount;


import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class JavaBatchWordCount {
    public static void main(String[] args) throws Exception {

        //1、获取Flink的执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //2、读取文件，并实现WordCount功能
        AggregateOperator<Tuple2<String, Integer>> sum = env.readTextFile("C:\\readme.txt")
                .flatMap(JavaBatchWordCount::flatMap)
                .groupBy(0)
                .sum(1);

        //3、保存到文件中
        sum.writeAsCsv("D:\\result", "\n", " ==> ").setParallelism(1);

        //4、执行
        env.execute("JavaBatchWordCount Example");
    }

    private static void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
        String[] strs = value.split(" ");
        for (String s : strs) {
            out.collect(new Tuple2<String, Integer>(s, 1));
        }
    }
}
