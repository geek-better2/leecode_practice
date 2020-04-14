package com.hai.leecode.sort;

/**
 * 插入排序：从左到右取出元素，第一个元素不懂门之后每个元素和之前元素比较，
 * 根据大小插入到适当的位置，其他的元素后移一个位置腾出空间。
 * 时间复杂度O（N方），空间复杂度O（N）
 * 受原有顺序影响，最坏情况倒序需要N2/2次比较和N2/2次交换，最好情况是正序有序，只需要N-1次比较，不需要交换
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,7,6,12,8,10};
        int[] sortArr = insertSort(arr);
        for (int i = 0; i < sortArr.length ; i++) {
            System.out.print(arr[i] + "\t");

        }

    }

    public static int[] insertSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
              SelectionSort.swapArr(arr,j,j-1);
            }
        }
        return arr;

    }
}
