package com.hai.leecode.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongConsecutive {

    //用了排序,会超时
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int length = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int max = 1;
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[j] - arr[i] == j - i) {
                max = Math.max(max, j - i + 1);
                break;
            }
            if (arr[i + 1] - arr[i] > 1) i++;
            if (arr[j] - arr[j - 1] > 1) j--;
        }

        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {100, 4, 200, 1, 3, 2, 2};
        int[] nums = {1,100};
        LongConsecutive instance = new LongConsecutive();
        int result = instance.longestConsecutive(nums);
        System.out.println("最大连续序列的长度为 " + result);
    }
}
