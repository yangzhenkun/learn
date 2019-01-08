package com.yasin.algorithm;

import org.junit.Test;

public class QuickSort2 {

    public void quickSort(int[] data, int start, int end) {

        int flag = data[start];
        int left = start;
        int right = end;

        while (left < right) {

            while (data[right] >= flag && left < right) {
                right--;
            }

            if (left < right) {
                data[left] = data[right];
            }

            while (data[left] <= flag && left < right) {
                left++;
            }

            if (left < right) {
                data[right] = data[left];
            }

        }

        data[left]=flag;

        if(start<left-1){
            quickSort(data,start,left-1);
        }
        if(end>right+1){
            quickSort(data,right+1,end);
        }

    }


    @Test
    public void run() {


        int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        quickSort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {

            System.out.println(data[i]);
        }

    }


}
