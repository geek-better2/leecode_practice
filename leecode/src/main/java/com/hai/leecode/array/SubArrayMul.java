package com.hai.leecode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hai
 * @date 2020-05-18 10:29
 */
public class SubArrayMul {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int mul = nums[i];
            max = Math.max(max, mul);
            for (int j = i + 1; j < length; j++) {
                mul = mul * nums[j];
                max = Math.max(max, mul);
            }
        }
        return max;
    }

    //动态规划
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max,imax);

        }

        return max;
    }


}
