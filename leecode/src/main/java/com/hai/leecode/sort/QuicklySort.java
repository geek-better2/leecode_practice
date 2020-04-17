package com.hai.leecode.sort;

public class QuicklySort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 1, 7, 2, 6, 11, 12, 13, 14, 10, 4, 8, 0};
        quicklySort(arr, 0, arr.length - 1);
        print(arr);

    }

    public static void quicklySort(int[] arr, int left, int right) {
        if (left >= right) return;
        int position = quickSwap(arr, left, right);
        //从轴的左边快排
        quicklySort(arr, left, position - 1);
        //从轴的右边快排
        quicklySort(arr, position + 1, right);

    }

    private static int quickSwap(int[] arr, int left, int rightBound) {
        int axis = arr[rightBound];
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= axis) left++;
            while (left <= right && arr[right] > axis) right--;
            if (left <= right) {
                swap(arr, left, right);
            }

        }
        swap(arr, left, rightBound);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
