package com.anand.threads.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(4);
        Thread.UncaughtExceptionHandler err = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " : Caught exception " + e.getMessage());
            }
        };

        List<RecursiveTask<Long>> tasks = LongStream.range(10,15).boxed().map(i-> {
            RecursiveTask<Long> t = new RcrsvTsk(i);
            return t;
        }).collect(Collectors.toList());

        List<Long> results = new ArrayList<>();
        for(RecursiveTask<Long> task : tasks){
            fjp.invoke(task);
        }

        for(RecursiveTask<Long> task : tasks){
            if(task.getException() != null){
                System.out.println("Exception : " + task.getException().getMessage());
            }else{
                results.add(task.join());
            }

        }


//        List<Long> allfactorials = fjp.invokeAll(tasks).stream().mapToInt(i->(Long)i).boxed().collect(Collectors.toList());
        System.out.println(results);
    }
}
