package com.hai.leecode.sort;

/**
 * 选择排序 每次都挑选剩余元素中的最小元素出来,依次与下标为0,1..n-2的元素交换位置
 * 两大特点:
 *  1、运行时间和输入无关
 *  2、数据移动是最少的
 *  排序算法考虑的是元素比较和交换的次数，还有额外内存的使用量
 *  选择排序需要大约N平方/2次比较和N次交换
 *  时间复杂度 O（N平方），空间复杂度O（N）
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,7,6,12,8,10};
        int[] sortArr = selectSort(arr);
        for (int i = 0; i < sortArr.length ; i++) {
            System.out.print(arr[i] + "\t");

        }


    }

   public static int[] selectSort(int[] arr){
        int n = arr.length;
       for (int i = 0; i < n; i++) {
          int min = i;
           for (int j = i+1; j < n; j++)
               if(arr[min] > arr[j]) min = j;
               swapArr(arr,i,min);
       }
        return arr;

   }

    public static void swapArr(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
