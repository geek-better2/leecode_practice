package com.hai.leecode.string;

import java.util.HashMap;

/**
 * @author hai
 * @date 2020-05-20 10:59
 */
public class LongestSubstringWithVowel {


    //leecode 英文官方最高vote 有点难理解
    public int findTheLongestSubstring(String s) {
        int res = 0, cur = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }

    public int findTheLongestSubstring2(String s) {
        int[] pos = new int[32];
        //为什么一定要单独设置一下pos[0]呢？？有点想不通
        pos[0] = 0;
        for (int i = 1; i < pos.length; i++) {
            pos[i] = -1;
        }
        int status = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = "aeiou".indexOf(c);
            if (index != -1) {
                status ^= 1 << index;
            }

            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }

        }

        return ans;

    }


    public static void main(String[] args) {
        String s = "deisgreat";
        LongestSubstringWithVowel instance = new LongestSubstringWithVowel();
        int ans = instance.findTheLongestSubstring2(s);
        System.out.println(ans);


    }
}
