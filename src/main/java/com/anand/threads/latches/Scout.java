package com.anand.threads.latches;

import java.util.concurrent.CountDownLatch;

public class Scout extends Thread {
    private CountDownLatch camp;

    Scout(CountDownLatch c){
        this.camp = c;
    }

    @Override
    public void run() {
        System.out.println("Scout " + Thread.currentThread().getName() + " is waiting to enter campground");
        try {
            camp.await();
            System.out.println("Scout " + Thread.currentThread().getName() + " is inside the campground");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
