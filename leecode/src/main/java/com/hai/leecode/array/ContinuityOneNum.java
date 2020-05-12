package com.hai.leecode.array;

/**
 * @author hai
 * @date 2020-05-08 15:50
 */
public class ContinuityOneNum {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count, max = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 1) {
                count = 1;
                int j = i + 1;
                while (j < nums.length && nums[j] == 1) {
                    count++;
                    j++;
                }
                i = j;
                if (max < count) max = count;

            } else {
                i++;
            }

        }

        return max;
    }

    //思路一致，代码更简洁，来自leecode官方解答
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }





    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int max = findMaxConsecutiveOnes(arr);
        System.out.println(max);

    }


}
