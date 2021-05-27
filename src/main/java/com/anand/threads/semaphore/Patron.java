package com.anand.threads.semaphore;

import java.util.Random;

public class Patron extends Thread{
    private String groupName;
    private int groupCount;
    private Restaurant restaurant;
    Patron(String name, int count, Restaurant rest){
        this.groupName=name;
        this.groupCount=count;
        this.restaurant = rest;
    }

    @Override
    public void run() {
        restaurant.getTable(this.groupName, this.groupCount);
        try{
            System.out.println(this.groupName + " is eating....");
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        restaurant.returnTable(this.groupName, this.groupCount);
    }
}
