package com.example.jm.jmm.util.gc;

public class TestGc {

    public static void main(String[] args) {

//        -XX:+PrintGC 输出GC日志
//        -XX:+PrintGCDetails 输出GC的详细日志
//        -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
//        -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
//        -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
//        -Xloggc:../logs/gc.log 日志文件的输出路径
        System.out.println("-XX:+PrintGCDetails");
        System.gc();



    }
}
