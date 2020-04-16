package com.hai.leecode.sort;

public class QuicklySort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 1, 7, 2, 6, 11, 15, 13, 14, 10, 4, 8, 12};
        quicklySort(arr);
        print(arr);

    }

    private static void quicklySort(int[] arr) {
        int temp = arr[arr.length-1];
        int i ,j;
        for ( i = 0,j = arr.length-2; i < (arr.length -1)/2 ; i++,j--) {


        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
