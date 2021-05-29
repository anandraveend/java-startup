package com.anand.threads.deadlock;

import java.util.Random;

public class DBResource {
    private NetworkResource net;
    DBResource(){

    }

    public NetworkResource getNet() {
        return net;
    }

    public void setNet(NetworkResource net) {
        this.net = net;
    }

    public synchronized void getDatabase(){
        System.out.println(Thread.currentThread().getName() + " has acquired database");
        try {
            Thread.sleep(new Random().nextInt(10000));
            System.out.println(Thread.currentThread().getName() + " waitin on network");
            net.getNetwork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





}
