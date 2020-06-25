package com.hai.leecode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hai
 * @Decription 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 *
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * @date 2020-03-05 10:19
 */
public class LongestNoRepeatSubString {

    //方法一、暴力循环法，时间复杂度O(n^3)
    public int lengthOfLongestSubString(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;

    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> c = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (c.contains(s.charAt(i))) {
                return false;
            }
            c.add(s.charAt(i));
        }
        return true;
    }



    //方法二、优化后的滑动窗口法，增加i的步长
    public int lengthOfLongestSubString3(String s) {
        int n = s.length();
        int ans = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);

            map.put(s.charAt(j), j + 1);

        }

        return ans;


    }

    //方法三,动态规划 + 哈希表
    public int lengthOfLongestSubString4(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;

    }




    public static void main(String[] args) {
        String s = "abckdebf";
        LongestNoRepeatSubString instance = new LongestNoRepeatSubString();
        int temp = instance.lengthOfLongestSubString3(s);
        System.out.println("最长的不重复子串长度为：" + temp);
    }
}
