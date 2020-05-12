package com.hai.leecode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hai
 * @date 2020-04-28 11:13
 */
public class NoLockNumberPrint {

    static   AtomicInteger num = new AtomicInteger(1);


    public static void main(String[] args) {


        new Thread(() -> print(1, "线程一")).start();
        new Thread(() -> print(4, "线程二")).start();
        new Thread(() -> print(7, "线程三")).start();

    }// 1 10  19
    // 4 13
    // 7 16 25

    static public void print(int target, String name) {

        while (true) {
            if (num.get() > 100) {
                break;
            }
            if (num.get() % 9 == target) {

                int i = 3;
                System.out.println(name + "打印开始");
                while (i > 0) {
                    System.out.println(Thread.currentThread().getName().substring(7)+ "  " + num.getAndAdd(1));
                    if (num.get() > 100) {
                        break;
                    }
                    i--;
                }
                System.out.println(name + "打印结束");
            }
        }
    }

}
