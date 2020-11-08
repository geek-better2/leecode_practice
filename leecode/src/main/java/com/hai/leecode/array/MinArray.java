package com.hai.leecode.array;

public class MinArray {

    public int minArray(int[] numbers) {
        int low = 0,high = numbers.length -1;
        while(low < high){
            int point = low + ((high -low) >> 1);
            if (numbers[point] > numbers[high]) {
                low = point + 1;
            } else if (numbers[point] < numbers[high]) {
                high = point;
            } else {
                high -= 1;
            }
        }
        return numbers[low];

    }


    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1};
        MinArray instance = new MinArray();
        int result = instance.minArray(arr);
        System.out.println("最小的数为: " + result);
    }


}
