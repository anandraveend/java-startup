package com.anand.threads;

public class ThreadCreationTypeTest extends Thread {
    public static void main(String[] args) {
        Thread t1 = new ThreadCreationTypeTest();
        Runnable r1 = () -> {
            System.out.println("Starting thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished thread " + Thread.currentThread().getName());
        };

        //extend thread
        t1.start();

        //Runnable
        new Thread(r1).start();
    }

    @Override
    public void run() {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished thread " + Thread.currentThread().getName());
    }
}
