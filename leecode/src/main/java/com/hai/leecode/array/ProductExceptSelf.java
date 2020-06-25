package com.hai.leecode.array;

public class ProductExceptSelf {
    //迭代左右侧数组的乘积,左右侧数组,空间复杂度为O(n)
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] output = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i -1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

    //迭代左右侧数组的乘积,但是左右侧乘积数组用结果数组替代,不适用额外空间,空间复杂度为O(1)
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        output[0] = 1;
        for (int i = 1; i < length; i++) {
            output[i] = output[i - 1] * nums[i -1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i];
        }

        return output;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,0};
        ProductExceptSelf instance= new ProductExceptSelf();
        int[] result = instance.productExceptSelf2(nums);
        for (int i = 0; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
