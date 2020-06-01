package com.hai.leecode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hai
 * @date 2020-05-27 09:24
 */
public class SubarraysDivByK {

    //暴力解法，时间超时
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    count++;
                }
            }

        }
        return count;

    }

    //hashMap存储前k项和
    public int subarraysDivByK2(int[] A, int K) {
        int count = 0, sum = 0;
        int length = A.length;
        //key为取模后的值，value为出现的次数，前缀和 sum[j] % K == sum[i] % K
        HashMap<Integer, Integer> map = new HashMap<>();
        //当前缀和与K的模为0时，sum[i]本身就是符合条件的，初始化为1。
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += A[i];
            //考虑到在java中，sum为负数时，取模后为负数，所以加K使取模值先转为正
            int module = (sum % K + K) % K;
            int value = map.getOrDefault(module,0);
            count += value;
            map.put(module,value + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 0, -2, -3, 1};
        SubarraysDivByK instance = new SubarraysDivByK();
        int count = instance.subarraysDivByK2(arr, 5);
        System.out.println(count);
    }
}
