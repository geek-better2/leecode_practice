package com.hai.leecode.sort;

public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 7, 8, 3, 6, 9};
        int[] arr = {9, 3, 5, 1, 7, 2, 6, 11, 15, 13, 14, 10, 4, 8, 12};
        sort(arr, 0, arr.length-1);
        print(arr);


    }

    static void sort(int[] arr, int left, int right) {
        if(left == right) return;
        int mid = left + (right - left) / 2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        merge(arr, left, mid + 1, right);
    }

    static void merge(int[] arr, int leftp, int rightp, int rightBound) {
        int mid = leftp + (rightBound - leftp) / 2;
        int[] temp = new int[rightBound - leftp + 1];
        int i = leftp;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];
        //print(temp);
        for (int l = 0; l < temp.length; l++) {
            arr[leftp + l] = temp[l];
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
