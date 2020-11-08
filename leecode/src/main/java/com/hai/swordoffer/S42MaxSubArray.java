package com.hai.swordoffer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S42MaxSubArray {

    /**
     * 动态规划 时间复杂度O(n),空间复杂度O(n),可优化空间复杂度为O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + Math.max(dp[i-1],0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**TODO
     * 分治法,时间复杂度O(nlogn),空间复杂度O(n)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums){

        return 0;
    }



    public static void main(String[] args) {


    }
}
