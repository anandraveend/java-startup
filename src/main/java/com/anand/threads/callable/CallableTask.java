package com.anand.threads.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    private String name;

    CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException{
        System.out.println("Starting work on " + name);
        int sleepFor = new Random().nextInt(1000);
        try {
            Thread.sleep(sleepFor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I slept for "+sleepFor;
    }
}
