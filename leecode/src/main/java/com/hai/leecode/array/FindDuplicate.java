package com.hai.leecode.array;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-26 11:32
 */
public class FindDuplicate {

    //使用了额外的O(n)的空间，不符合题意
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i] - 1] < 0) {
                return nums[i];
            } else {
                arr[nums[i] - 1] = nums[i] * (-1);
            }

        }
        return -1;

    }

    //二分法，时间换空间的方式，复杂度为O(nlogn) [1,2,2,3,4,5,6,7]
    public int findDuplicate2(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) >>> 2;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if(mid >= nums[i]){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            } else {
                left = mid + 1;

            }
        }
        return left;

    }

    //快慢指针法判断是否有环，太难了，不会啊
    public int findDuplicate3(int[] nums){
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,5,6,7};
        FindDuplicate instance = new FindDuplicate();
        int num = instance.findDuplicate(nums);
        System.out.println(num);
    }

}
