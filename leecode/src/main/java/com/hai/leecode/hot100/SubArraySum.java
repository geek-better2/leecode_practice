package com.hai.leecode.hot100;

import java.util.HashMap;

/**
 * leecode 560
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-15 09:47
 */
public class SubArraySum {

    //暴力解法
    public int subArraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
            sum = 0;

        }
        return count;
    }

    //前缀和+哈希表
    public int subArraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);


        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        SubArraySum instance = new SubArraySum();
        int count = instance.subArraySum(nums, 2);
        System.out.println(count);
    }


}
