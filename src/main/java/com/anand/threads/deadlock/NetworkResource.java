package com.anand.threads.deadlock;

import java.util.Random;

public class NetworkResource {
    private DBResource db;
    NetworkResource(){

    }

    public DBResource getDb() {
        return db;
    }

    public void setDb(DBResource db) {
        this.db = db;
    }

    public synchronized void getNetwork(){
        System.out.println(Thread.currentThread().getName() + " has acquired network");
        try {
            Thread.sleep(new Random().nextInt(10000));
            System.out.println(Thread.currentThread().getName() + " waitin on DB");
            db.getDatabase();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
