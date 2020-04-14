package com.hai.leecode.sort;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author hai
 * @date 2020-04-14 09:38
 */
public class MergeSort {

    public static void main(String[] args) {
        //int[] arr = {9, 3, 5, 1, 7, 2, 6, 11, 15, 13, 14, 10, 4, 8, 12};
        int[] arr = {1, 3, 5, 7, 2, 6, 8, 9};
        mergeSort(arr, 0, arr.length);

        printArr(arr);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //左边排序
            /*mergeSort(arr, left, mid);
            //右边排序
            mergeSort(arr, mid + 1, right);*/
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[arr.length];
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) {
            arr[l] = temp[l];
        }

    }


    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
