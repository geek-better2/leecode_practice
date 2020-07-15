package com.hai.leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Insertsect {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        int length = Math.min(nums1.length,nums2.length);
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = l1.iterator();
        while(iterator.hasNext()){
            Integer temp = iterator.next();
            if(l2.contains(temp)){
                iterator.remove();
                l2.remove(temp);
                result.add(temp);
            }

        }
        return  result.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {

    }
}
