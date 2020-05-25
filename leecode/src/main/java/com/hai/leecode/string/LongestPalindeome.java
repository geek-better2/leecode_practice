package com.hai.leecode.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-21 09:32
 */
public class LongestPalindeome {

    //暴力求解法
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length(), max = 0;
        String ans = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                boolean p = isPalindrome(temp);
                if (p && temp.length() > max) {
                    ans = s.substring(i, j);
                    max = ans.length();

                }
            }

        }
        return ans;

    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    //动态扩展中心法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0, len = s.length();
        for (int i = 0; i < s.length(); i++) {
            //回文的最大奇数长度
            int length1 = findMaxSubString(s, i, i);
            //回文的最大偶数长度
            int length2 = findMaxSubString(s, i, i + 1);
            int max = Math.max(length1, length2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }


        return s.substring(start, end + 1);

    }

    private int findMaxSubString(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }


    public static void main(String[] args) {
        String s = "cbba";
        LongestPalindeome instance = new LongestPalindeome();
        String sub = instance.longestPalindrome(s);
        System.out.println(sub);
    }

}
