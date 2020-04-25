package com.hai.leecode.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author hai
 * @date 2020-04-24 23:35
 */
public class SemaphoreNumberPrint {
    static final Semaphore sem = new Semaphore(1);

    static volatile int state = 0;

    static  volatile int count = 0;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                while (count <= 97) {
                    while (state % 3 != 0) {
                        sem.release();
                    }
                    sem.acquire();
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("A " + count);
                        if(count == 100) break;
                    }
                    state++;
                    sem.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                while (count < 93) {
                    while (state % 3 != 1) {
                        sem.release();
                    }
                    sem.acquire();
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("B " + count);
                    }
                    state++;
                    sem.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadC implements Runnable {

        @Override
        public void run() {
            try {
                while (count < 93) {
                    while (state % 3 != 2) {
                        sem.release();
                    }
                    sem.acquire();
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("C " + count);
                    }
                    state++;
                    sem.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }
}
