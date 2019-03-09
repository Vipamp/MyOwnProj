/**
 * @Author:HeQingsong
 * @Date:2018/9/11 11:39
 * @Describe： 这个是在命令行中，通过指定命令参数的方式，获取执行的参数
 */
package ParamAnalysis;

import org.apache.flink.api.java.utils.ParameterTool;

public class JavaParamsUtils {

    public static String getParams(String[] args, String paramName) {
        //在其他类执行main方法中，通过这种方式解析参数，后面可以在命令行中，可以当命令行参数使用
        ParameterTool parameter = ParameterTool.fromArgs(args);
        try {
            return parameter.get(paramName);
        } catch (Exception e) {
            return null;
        }
    }
}
