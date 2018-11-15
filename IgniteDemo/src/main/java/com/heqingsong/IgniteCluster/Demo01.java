/**
 * @ClassName：IgniteLocalNode
 * @Author：HeQingsong
 * @Date：2018/9/17 9:47
 * @Since：JDK1.8
 * @Version：1.0
 * @Description：测试集群管理对象，获取集群信息
 */
package com.heqingsong.IgniteCluster;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCluster;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterMetrics;
import org.apache.ignite.cluster.ClusterNode;

public class Demo01 {
    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        //1、获取集群管理对象
        IgniteCluster cluster = ignite.cluster();

        //2、获取本地集群节点对象
        ClusterNode localNode = cluster.localNode();

        //3、获取节点参数集
        ClusterMetrics metrics = localNode.metrics();

        //4、获取节点参数
        Double cpuLoad = metrics.getCurrentCpuLoad();
        System.out.println("CpuLoad:" + cpuLoad);
        long userHeap = metrics.getHeapMemoryUsed();
        System.out.println("UserHeap:" + userHeap);
        int numberOfCore = metrics.getTotalCpus();
        System.out.println("NumberOfCore:" + numberOfCore);
        int activeJobs = metrics.getCurrentActiveJobs();
        System.out.println("ActiveJobs:" + activeJobs);

        ignite.close();
    }
}
