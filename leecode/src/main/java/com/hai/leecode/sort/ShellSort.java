package com.hai.leecode.sort;

/**
 * 希尔排序:优化后的插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 6, 12, 8, 10};
        int[] sortArr = shellSort(arr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(arr[i] + "\t");

        }

    }

    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    SelectionSort.swapArr(arr, j, j - h);
                }
            }
            h = h / 3;
        }
        return arr;
    }
}
