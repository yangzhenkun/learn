package com.yasin.algorithm;

/**
 * @author yangzhenkun
 * @create 2018-12-12 14:41
 */
public class BinarySearch {


    public static void main(String[] args){

        int[] a = {0,1,2,3,4,5,6,7,8,9,10,20};

        int find =6;

        int left = 0,right = a.length-1;

        while(left<=right){

            int flag = (left+right)/2;

            if(find==a[flag]){
                System.out.println("find index="+flag);
                break;
            }

            if(find<flag){
                right = flag-1;
            }else{
                left = flag+1;
            }

        }

        if(left>right){
            System.out.println("not find "+find);
        }

    }



}
