package com.hai.leecode.array;

/**
 * @author hai
 * @date 2020-05-08 14:28
 */
public class MoveZeros {

    public static int[] moveZero(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {

            if (arr[i] == 0) {
                int j = i + 1;
                while (j < length - 1 && arr[j] == 0) {
                    j++;
                }
                swap(arr, i, j);

            }

        }
        return arr;

    }


    public static int[] moveZero2(int[] arr) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < arr.length; cur++) {
            if (arr[cur] != 0) {
                swap(arr,lastNonZeroFoundAt,cur);
                lastNonZeroFoundAt++;
            }
        }

        return arr;



    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZero2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
