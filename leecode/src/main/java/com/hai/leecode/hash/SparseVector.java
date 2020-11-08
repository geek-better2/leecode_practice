package com.hai.leecode.hash;


import java.util.HashMap;

/**
 * 稀疏矩阵的hash表实现
 */
public class SparseVector {
    private HashMap<Integer, Integer> st;

    public SparseVector() {
        st = new HashMap<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, int value) {
        st.put(i, value);
    }

    public int get(int i) {
        if (!st.containsKey(i)) return 0;
        return st.get(i);

    }

    public int dot(int[] that) {
        int sum = 0;
        for (int i : st.keySet()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        SparseVector[] a = new SparseVector[5];
        for (int i = 0; i < a.length ; i++) {
            a[i] = new SparseVector();
        }
        a[0].put(1,90);
        a[1].put(2,36);
        a[1].put(3,36);
        a[1].put(4,18);
        a[2].put(3,90);
        a[3].put(0,90);
        a[4].put(0,45);
        a[4].put(2,45);
        int[] x = new int[]{5,4,36,37,19};
        int[] b = new int[5];
        for(int i = 0; i < 5; i++){
            b[i] = a[i].dot(x);
        }
        System.out.println("向量的结果值为: ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }

    }

}
