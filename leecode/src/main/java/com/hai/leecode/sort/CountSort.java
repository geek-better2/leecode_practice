package com.hai.leecode.sort;

import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3,3,3,2,2,2,4,4,1,3,5,6,5,6};
        countSort(arr);
        print(arr);

    }

    private static void countSort(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <=6 ; i++) {
            map.put(i,0);
        }
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                 int oldValue = map.get(arr[i]);
                 map.put(arr[i],oldValue + 1);
            }
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> a:map.entrySet()){
            for (int j = 1; j <= a.getValue() ; j++) {
                arr[i] = a.getKey();
                i++;
            }
        }

    }


    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
