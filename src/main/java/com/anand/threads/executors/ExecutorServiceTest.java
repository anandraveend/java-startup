package com.anand.threads.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService svc = Executors.newFixedThreadPool(3);
        for(int i=0;i< 10;i++){
            Worker work = new Worker("Work#" + i);
            svc.submit(work);
        }
        svc.shutdown();
    }
}
