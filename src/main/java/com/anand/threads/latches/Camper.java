package com.anand.threads.latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Camper extends Thread {
    private String duty;
    private CountDownLatch latch;

    Camper(String duty, CountDownLatch l){
        this.duty=duty;
        this.latch = l;
    }

    @Override
    public void run() {
        System.out.println(duty + " prepping for camping...");
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(duty + " ready for camping...");
            latch.countDown();
        }
    }
}
