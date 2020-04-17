package com.hai.leecode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hai
 * @date 2020-04-14 09:40
 */
public class SortCheck {
    public static void main(String[] args) {
         boolean result = mutiCheck();
        System.out.println("对比的结果是：" + result);



    }

    private static boolean mutiCheck() {
        boolean result = false;
        for (int j = 0; j < 1000; j++) {
            int[] arr = randomNumber();
            int[] test = new int[arr.length];
            for (int i = 0; i < arr.length ; i++) {
                test[i] = arr[i];
            }
            Arrays.sort(arr);
            //MergeSort.sort(test,0,test.length - 1);
            QuicklySort.quicklySort(test,0,test.length - 1);
            result = compareSort(arr,test);
            //System.out.println("对比的结果是:" + result);
            if( !result) break;
        }
        return result;

    }

    private static int[] randomNumber() {
        Random random = new Random();
        int[]  temp = new int[10000];
        for (int i = 0; i < temp.length ; i++) {
             temp[i] = random.nextInt(1000000);
        }
        return temp;
    }

    private static boolean compareSort(int[] arr, int[] test) {
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] != test[i] ) return false;
        }
        return true;
    }


}
