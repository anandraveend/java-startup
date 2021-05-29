package com.anand.threads.deadlock;

import java.util.Random;

public class Worker implements Runnable {
    private DBResource db;
    private NetworkResource net;
    int decider;
    Worker(DBResource r,NetworkResource net, int i){
        this.db = r;
        this.net = net;
        this.decider =i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started");
        if(decider % 2 == 0){
            System.out.println(Thread.currentThread().getName() + " will work on network");
            net.getNetwork();
        }
        else{
            System.out.println(Thread.currentThread().getName() + " will work on database");
            db.getDatabase();
        }
    }
}
