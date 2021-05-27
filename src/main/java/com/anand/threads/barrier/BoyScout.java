package com.anand.threads.barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BoyScout extends Thread{
    private String duty;
    private CyclicBarrier barrier;

    public BoyScout(String duty, CyclicBarrier b){
        this.duty = duty;
        this.barrier = b;
    }

    @Override
    public void run() {
        System.out.println("Scout is working on " + duty);
        try {
            Thread.sleep(new Random().nextInt(10000));
            System.out.println(duty + " scout is done with his duties");
            barrier.await();
            System.out.println(duty + " scout is partying hard!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch(BrokenBarrierException b){
            b.printStackTrace();
        }
    }
}
