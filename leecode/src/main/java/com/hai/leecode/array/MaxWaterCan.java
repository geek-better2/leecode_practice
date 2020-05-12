package com.hai.leecode.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author hai
 * @date 2020-05-08 13:43
 */
public class MaxWaterCan {


    public static int maxArea(int[] height) {
        int area = 0, i, j;
        int length = height.length;
        for (i = 0, j = length - 1; i < height.length && j >= 0; ) {
            int min = height[i] <= height[j] ? height[i] : height[j];
            if (area < min * (j - i)) area = min * (j - i);

            if (min == height[i]) {
                i++;
            } else {
                j--;
            }

        }
        return area;

    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = maxArea(arr);
        System.out.println("最大的容器盛水量为：" + maxArea);
    }
}
