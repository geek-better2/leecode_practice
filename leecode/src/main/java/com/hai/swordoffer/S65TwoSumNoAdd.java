package com.hai.swordoffer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S65TwoSumNoAdd {

    //迭代的方式实现
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    //递归方式实现
    public int add2(int a, int b) {
        if (b == 0) {
            return a;
        }

        return add2(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = -7;
        S65TwoSumNoAdd instance = new S65TwoSumNoAdd();
        int sum = instance.add2(a, b);
        System.out.println("两数之和(不使用四则运算符)的结果为: " + sum);
    }
}
