package com.anand.threads.semaphore;

import java.util.concurrent.Semaphore;

public class Restaurant {
    private final Semaphore tables;

    Restaurant(){
        tables = new Semaphore(10);
    }
    public void getTable(String name, int groupCount){
        System.out.println(name + " is trying to acquire a table for " + groupCount + " and " + tables.availablePermits() + " tables are available...");

        try {
            tables.acquire(groupCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " have to acquire a table for " + groupCount);
    }
    public void returnTable(String name, int groupCount){
        System.out.println(name + " have to returned a table for " + groupCount);
        tables.release(groupCount);
    }

}
