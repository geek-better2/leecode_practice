package com.hai.leecode.array;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {

    /**
     * 双指针法,时间复杂度为O(n)
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0;
        int n = nums.length, ans = Integer.MAX_VALUE;
        if (n == 0) {
            return 0;
        }
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    /**
     * 前缀和 + 二分查找法, 时间复杂度为O(nlogn),
     * 虽然时间复杂度没有双指针法好,但是是一个很好的利用二分和前缀和思想的一道题.
     * 相关的题可借鉴该思想.
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //sum[] 数组表示以i为结尾的前i项和组成的数组,
        // 而连续的k到i的前缀和则为 sum[i] - sum[k-1] >= s
        int[] sum = new int[n + 1];
        sum[0] = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < sum.length; i++) {
            int temp = sum[i - 1] + s;
            int index = Arrays.binarySearch(sum, temp);
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= n) {
                ans = Math.min(ans, index - i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 5, 3};
        MinSubArrayLen instance = new MinSubArrayLen();
        int res = instance.minSubArrayLen2(7, nums);
        System.out.println("最短的连续子数组长度为: " + res);

    }
}
