package com.hai;

public class JvmParameterTest {

    public static void main(String[] args) {
        System.out.println("......helloGC");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
