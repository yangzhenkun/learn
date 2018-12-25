package com.yasin.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间覆盖问题
 * 使用快排对输入区间进行排序，平均复杂度nlogn
 * 对排序好的区间进行合并，复杂度 n
 * 使用二分对合并好的区间进行搜索，单次搜索的结果为logn
 *
 * @author yangzhenkun
 * @create 2018-12-25 10:12
 */
public class ZoneCover {


    /**
     * 使用快排对输入区间进行排序
     *
     * @param zones
     * @param left
     * @param right
     */
    public void qsort(Zone[] zones, int left, int right) {

        if (left >= right)
            return;

        Zone flag = zones[left];

        int start = left;
        int end = right;

        while (start < end) {

            while (start < end && zones[end].min >= flag.min) {
                end--;
            }
            if (start < end) {
                zones[start] = zones[end];
                start++;
            }

            while (start < end && zones[start].min <= flag.min) {
                start++;
            }

            if (start < end) {
                zones[end] = zones[start];
                end--;
            }
        }

        zones[start] = flag;
        if (left < start - 1) {
            qsort(zones, left, start - 1);
        }

        if (right > end + 1) {
            qsort(zones, end + 1, right);
        }

    }

    /**
     * 对合并好的区间进行合并
     *
     * @param zones
     */
    public Zone[] merge(Zone[] zones) {

        List<Zone> zl = new ArrayList<>();

        Zone c = new Zone();
        c.min = 0;
        c.max = 0;
        for (Zone zone : zones) {

            if (zone.min > c.max) {//说明产生不连续区间
                c = new Zone();
                c.min = zone.min;
                c.max = zone.max;
                zl.add(c);
            } else if (zone.max > c.max) {//如果左区间覆盖，比较右区间，如果大于当前的右区间，就进行扩展
                c.max = zone.max;
            }

        }

        Zone[] merged = new Zone[zl.size()];

        return zl.toArray(merged);
    }

    /**
     * 使用二分进行搜索
     * @param zones
     * @param targe
     * @return
     */
    public boolean isExist(Zone[] zones, Zone targe) {

        int left = 0;
        int right = zones.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            /**
             * 一个目标区间在搜索中的3中情况
             * 1.目标区间在搜索区间右边，即targe.min>zone.max，此时对搜索区间的右边进行搜索
             * 2.目标区间的左边界落在搜索区间中；如果目标区间的右边界也落在搜索区间，则目标区间是在全区间中存在的；反之则不存在
             * 3.目标区间在搜索区间左边，即targe.min<zone.min，此时对搜索区间的左边进行搜索
             *
             */
            if (targe.min > zones[mid].max) {
                left = mid+1;
                continue;
            } else if (targe.min >= zones[mid].min) {
                return (targe.max <= zones[mid].max);
            } else {
                right = mid-1;
            }

        }
        return false;
    }


    private class Zone {

        int min;
        int max;

    }

    @Test
    public void test() {

        Zone z1 = new Zone();
        z1.min = 1;
        z1.max = 5;

        Zone z2 = new Zone();
        z2.min = 5;
        z2.max = 6;

        Zone z3 = new Zone();
        z3.min = 13;
        z3.max = 19;

        Zone[] zones = new Zone[3];
        zones[0] = z1;
        zones[1] = z2;
        zones[2] = z3;

        qsort(zones, 0, 2);

        /**
         * 看看排序是否对
         */
        System.out.println("排序结果");
        for (Zone zone : zones) {
            System.out.println("min=" + zone.min + "====max=" + zone.max);

        }

        /**
         * 看看排序是否对
         */
        System.out.println("合并结果");
        Zone[] merged = merge(zones);
        for (Zone zone : merged) {
            System.out.println("min=" + zone.min + "====max=" + zone.max);
        }

        Zone f1 = new Zone();
        f1.min = 1;
        f1.max = 5;
        System.out.println("通过验证:" + (isExist(merged, f1) == true));

        f1.min = 1;
        f1.max = 7;
        System.out.println("通过验证:" + (isExist(merged, f1) == false));


        f1.min = 7;
        f1.max = 8;
        System.out.println("通过验证:" + (isExist(merged, f1) == false));

        f1.min = 7;
        f1.max = 14;
        System.out.println("通过验证:" + (isExist(merged, f1) == false));


        f1.min = 14;
        f1.max = 18;
        System.out.println("通过验证:" + (isExist(merged, f1) == true));


        f1.min = 14;
        f1.max = 20;
        System.out.println("通过验证:" + (isExist(merged, f1) == false));


        f1.min = 20;
        f1.max = 22;
        System.out.println("通过验证:" + (isExist(merged, f1) == false));

    }


}
