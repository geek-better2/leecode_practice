package com.hai.leecode.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hai
 * @date 2020-04-24 23:25
 */
public class LockNumberPrint {

    static Lock lock = new ReentrantLock();
    static Condition A = lock.newCondition();
    static Condition B = lock.newCondition();
    static Condition C = lock.newCondition();

    static volatile int state = 0;

    static volatile int count = 0;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (count <=  100) {
                    while (state % 3 != 0) {
                        A.await();
                    }
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("A " + count);
                        if(count == 100) break;
                    }
                    state++;
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (count < 93) {
                    while (state % 3 != 1) {
                        B.await();
                    }
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("B " + count);
                    }
                    state++;
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (count < 93) {
                    while (state % 3 != 2) {
                        C.await();
                    }
                    for (int j = 0; j < 3; j++) {
                        count++;
                        System.out.println("C " + count);
                    }
                    state++;
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }


}
