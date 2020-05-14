package com.hai.leecode.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * 的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author hai
 * @date 2020-05-14 11:10
 */
public class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //最小的数都大于0，则
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi ) {
                if (nums[lo] + nums[hi] + nums[i]== 0) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] + nums[i]< 0) {
                    lo++;

                } else {
                    hi--;
                }
            }


        }
        return list;

    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeNumberSum instance = new ThreeNumberSum();
        List<List<Integer>> list = instance.threeSum(nums);
        for (List<Integer> a: list) {
            System.out.println(Arrays.toString(a.toArray()));
        }

    }
}
