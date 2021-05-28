package com.anand.threads.callable;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService svc = Executors.newFixedThreadPool(3);

        List<Future<String>> resultsF = IntStream.range(1,10).mapToObj(i-> svc.submit(new CallableTask("Task#"+ i))).collect(Collectors.toList());
        resultsF.forEach(e-> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.getMessage();
            }
        });

        //What is the problem with this code??? :)
        List<String> results = IntStream.range(1,10).mapToObj(i-> {
            Future<String> result = svc.submit(new CallableTask("Task#"+ i));
            String value = null;
            try {
                value = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return value;
        }).collect(Collectors.toList());


        System.out.println(results);
        svc.shutdown();
    }
}
