package com.hai.leecode.concurrent;


/**
 * 我们提供了一个类：顺序打印
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrderPrint {
    private boolean first;
    private boolean second;
    private Object lock = new Object();

    public OrderPrint() {
    }

    public void first(Runnable printFirst) throws Exception{
        synchronized(lock){
            printFirst.run();
            first = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws Exception{
        synchronized(lock){
            while(!first){
               lock.wait();
            }
            printSecond.run();
            second = true;
            lock.notifyAll();

        }

    }
    public void third(Runnable printThird) throws Exception{
        synchronized(lock){
            while(!second){
                lock.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) {
        OrderPrint o = new OrderPrint();
        new Thread(() -> {
            try {
                o.first(()-> System.out.println(Thread.currentThread().getName()+"第一个数据打印出来"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                o.second(()-> System.out.println(Thread.currentThread().getName()+"第二个数据打印出来"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                o.third(()-> System.out.println(Thread.currentThread().getName()+"第三个数据打印出来"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();



    }

}
