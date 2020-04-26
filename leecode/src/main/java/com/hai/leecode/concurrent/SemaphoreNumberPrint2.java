package com.hai.leecode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hai
 * @date 2020-04-25 18:18
 */
public class SemaphoreNumberPrint2 {

    static final AtomicInteger num = new AtomicInteger(1);
    private static Semaphore one = new Semaphore(1);
    private static Semaphore two = new Semaphore(0);
    private static Semaphore three = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                while (num.intValue() <= 100) {
                    gogogo(one, two);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "1").start();
        new Thread(() -> {
            try {
                while (num.intValue() <= 100) {
                    gogogo(two, three);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "2").start();
        new Thread(() -> {
            try {
                while (num.intValue() <= 100) {
                    gogogo(three, one);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "3").start();
    }

    private static void gogogo(Semaphore acquire, Semaphore release) throws InterruptedException {
        acquire.acquire();

        int initValue = num.intValue();
        System.out.print(Thread.currentThread().getName() + "    ");
        while (num.intValue() - initValue < 3 && num.intValue() <= 100) {
            System.out.print(" " + num.getAndIncrement());
        }
        System.out.println();

        release.release();
    }
}
