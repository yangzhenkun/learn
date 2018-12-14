package com.yasin.jdklearn.gc;

import org.junit.Test;

public class App {

    private final int _1MB = 1024 * 1024;

    @Test
    public void main() {
//        testAllocation();
//        byte[] d = new byte[4 * _1MB];
//		testHandlePromotion();
        // testPretenureSizeThreshold();
        // testTenuringThreshold();
        // testTenuringThreshold2();
//        for(int i=0;i<30;i++){
//            byte[] d = new byte[1 * _1MB];
//        }


    }


    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     */
    @SuppressWarnings("unused")
    public void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[4 * _1MB];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
//		System.gc();
//		allocation5 = new byte[5 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    @SuppressWarnings("unused")
    public void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; // 直接分配在老年代中
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4]; // allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     */
    @SuppressWarnings("unused")
    public void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
