package com.anand.threads.executors;

import java.util.Random;

public class Worker implements Runnable {
    private String unitOfWork;
    Worker(String work){
        this.unitOfWork = work;
    }
    @Override
    public void run() {
        System.out.println("Starting on " + unitOfWork +" by " + Thread.currentThread().getName() );
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + unitOfWork +" by " + Thread.currentThread().getName() );
    }
}
