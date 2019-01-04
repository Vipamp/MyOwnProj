/**
 * @ClassName：Demo02
 * @Author：HeQingsong
 * @Date：2018/9/17 9:57
 * @Since：JDK1.8
 * @Version：1.0
 * @Description：将计算任务广播到其他节点上
 */
package com.heqingsong.IgniteCluster;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCluster;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;

public class Demo02 {
    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        IgniteCluster cluster = ignite.cluster();
        IgniteCompute compute = ignite.compute(cluster.forRemotes());
        compute.broadcast(() -> System.out.println("Hello Node: " + ignite.cluster().localNode().id()));
        ignite.close();
    }
}
