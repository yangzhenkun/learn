package com.yasin.algorithm;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author yangzhenkun
 * @create 2019-02-14 10:42
 */
public class TOPK {


    @Test
    public void test() {

        int[] array = {1, 10, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60, 7, 70, 8, 80, 9, 90};
        int k = 10;

//        topk2(array, k);

        partion(array,0,array.length-1,k);

        for (int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }

    }

    //单次排序
    private void partion(int[] data, int low, int high,int k) {
        int start = low;
        int end = high;
        int mid = data[low];
        while (low < high) {
            while (low < high && data[high] <= mid) {
                high--;
            }
            if (low < high) {
                data[low] = data[high];
                low++;
            }
            while (low < high && data[low] >= mid) {
                low++;
            }
            if (low < high) {
                data[high] = data[low];
                high--;
            }
        }
        data[low] = mid;
        if(low>k){
            partion(data,start,low-1,k);
        }else if(low<k){
            partion(data,low+1,end,k);
        }


    }

    private void topk2(int[] data, int k) {
        k--;//因为数组从0开始存储，对k减一
        int high = data.length - 1;
        int low = 0;
        int index = 0;
        partion(data, low, high,k);

        while (index != k) {

            if (index > k) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            partion(data, low, high,k);

        }

    }


    private TreeSet<Integer> topk(int[] array, int n) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (set.size() < n) set.add(value);
            else {
                int min = set.first();
                if (value > min) {
                    set.remove(min);
                    set.add(value);
                }
            }
        }
        return set;
    }




}
