package com.hai.leecode.array;

/**leecode 1437题
 * @author hai
 * @date 2020-05-08 17:01
 */
public class KLengthApart {

    public static  boolean kLengthApart(int[] nums, int k) {
        int count  = k;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if (count < k) {
                    return false;
                }
                count = 0;
            }else{
                count++;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,0,1};
        boolean value = kLengthApart(arr,2);
        System.out.println(value);
    }

}
