package com.anand.threads.forkjoin;

import java.util.concurrent.RecursiveTask;

public class RcrsvTsk extends RecursiveTask<Long> {
    private Long n;

    RcrsvTsk(Long n){
        this.n=n;
    }
    private Long factorial(Long n){
        //emulate time consuming task

        if (n == 1)
            return 1L;
        else
            return n * factorial(n-1);
    }

    public Long compute(){
        System.out.println(Thread.currentThread().getName() + " starting calculation on " + n);
        Long result = factorial(this.n);
        System.out.println(Thread.currentThread().getName() + " completed calculation on " + n + " factorial : " + result);
        return result;
    }
}
