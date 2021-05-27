package com.anand.threads.phasers;

import java.util.Random;
import java.util.concurrent.Phaser;

public class ParkRide extends Thread {
    private String rideCar;
    private Phaser carSize;

    public ParkRide(String ride, Phaser p){
        this.carSize = p;
        this.rideCar = ride;
    }

    @Override
    public void run() {
        System.out.println("waiting to fill ride car " + rideCar);
        try {
            carSize.arriveAndAwaitAdvance();
            System.out.println("Car ride started....");
            Thread.sleep(new Random().nextInt(1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
