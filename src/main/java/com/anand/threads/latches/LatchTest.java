package com.anand.threads.latches;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
    public static void main(String[] args) {
        CountDownLatch camping = new CountDownLatch(3);
        Runnable campers = () -> {
            for(int i=0; i<=4;i++){
                Camper c = new Camper("Camp Master:" + i, camping);
                c.start();
            }
        };
        //First batch..waits for campe to be ready
        for(int i=0;i<10;i++){
            Scout s = new Scout(camping);
            s.start();
        }

        //Start the prep
        new Thread(campers).start();

        while(!(camping.getCount() == 0)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Second batch..should not wait for camp to be ready as last is already set to 0
        for(int i=0;i<10;i++){
            Scout s = new Scout(camping);
            s.start();
        }
    }
}
