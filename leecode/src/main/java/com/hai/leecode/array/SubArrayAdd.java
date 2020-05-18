package com.hai.leecode.array;

/**
 * leecode 53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-18 11:23
 */
public class SubArrayAdd {

    //动态规划，一次遍历
    public int maxSubArray(int[] nums) {
        int max = nums[0], imax = 0;
        for (int i = 0; i < nums.length; i++) {
            imax = imax > 0 ? (imax + nums[i]) : nums[i];
            max = Math.max(max, imax);
        }

        return max;
    }

    //分治法 递归   好难啊，我不会
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        return maxSubArrayHelperFunction(nums, 0, n - 1);
    }

    private int maxSubArrayHelperFunction(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int middle = (left + right) / 2;
        int leftMax = maxSubArrayHelperFunction(nums, left, middle);
        int rightMax = maxSubArrayHelperFunction(nums, middle + 1, right);
        int leftTemp = nums[middle], temp = 0, rightTemp = nums[middle + 1];

        for (int i = middle; i >= left; i--) {
            temp = temp + nums[i];
            leftTemp = Math.max(temp, leftTemp);
        }
        int temp2 = 0;
        for (int i = middle + 1; i <= right; i++) {
            temp2 = temp2 + nums[i];
            rightTemp = Math.max(temp2, rightTemp);
        }
        return Math.max(Math.max(leftMax, rightMax), rightTemp + leftTemp);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        SubArrayAdd instance = new SubArrayAdd();
        int max = instance.maxSubArray2(arr);
        System.out.println(max);
    }


}
