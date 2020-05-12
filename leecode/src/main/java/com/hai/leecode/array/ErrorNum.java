package com.hai.leecode.array;

/** leecode 645
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 *  输入: nums = [1,2,2,4]
 *  输出: [2,3]
 * 注意:
 *  给定数组的长度范围是 [2, 10000]。
 *  给定的数组是无序的。
 * @author hai
 * @date 2020-05-09 10:31
 */
public class ErrorNum {
    /**
     * 来自leecode 官方解答
     * 映射法，遍历数组，将每个数字都映射到对应的index上，第一次映射时，将值修改为负数，
     * 如果第二次又映射到，说明该数是重复数字，之后再遍历一边数组，唯一的一个正数的索引值+1便是缺失的那个数字
     * @param nums
     * @return
     */
    public  static int[] findErrorNums(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};

    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] result = findErrorNums(arr);
        /*try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int n: result) {
            System.out.print(n + "  ");

        }


    }


}
