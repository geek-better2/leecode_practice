package com.hai.leecode.concurrent;

import java.util.concurrent.CountDownLatch;

public class OrderPrintCountDownlatch {
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public OrderPrintCountDownlatch() {
    }

    public void first(Runnable printFirst) throws Exception{
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws Exception{
        second.await();
        printSecond.run();
        third.countDown();
    }
    public void third(Runnable printThird) throws Exception{
        third.await();
        printThird.run();
    }




}
