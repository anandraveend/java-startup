package com.anand.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatesTest extends Thread{
    Lock lock;
    ThreadStatesTest(ReentrantLock lock){
        this.lock = lock;
    }
    public static void main(String[] args) throws Exception{
        ReentrantLock l = new ReentrantLock();
        Thread t1 = new ThreadStatesTest(l);
        Thread t2 = new ThreadStatesTest(l);
        System.out.println(t1.getName() + " is in state : " + t1.getState());
        t1.start();
        t2.start();
        while(t1.isAlive() && t2.isAlive()){
            System.out.println(t1.getName() + " : " + t1.getState());
            System.out.println(t2.getName() + " : " + t2.getState());
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is in state : " + Thread.currentThread().getState());
        try{
            if(lock.tryLock()){
                System.out.println(Thread.currentThread().getName() + " Acquired lock!");
                Thread.sleep(5000);
            }else{
                while(!lock.tryLock()){
                    System.out.println(Thread.currentThread().getName() + " Waiting for lock:" + Thread.currentThread().getState());
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + " Acquired lock!");
            }
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }

        System.out.println(Thread.currentThread().getName() + " Completed... is in state : " + Thread.currentThread().getState());
    }
}
