package com.hai.leecode.hot100;

/**
 * leecode 136  只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-15 09:36
 */
public class NumberOnlyOne {


    /**
     * 异或运算
     * 1、任何数和 0 做异或运算，结果仍然是原来的数，即 a^0 = a
     * 2、任何数与自身做异或运算，其结果是0
     * 3、异或运算满足交换律和结合律，即a^b^a = b^a^a = b^0 = b
     *
     * @param nums
     * @return
     */
    public int singleNum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        NumberOnlyOne instance = new NumberOnlyOne();
        int res = instance.singleNum(nums);
        System.out.println(res);
    }
}
