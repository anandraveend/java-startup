package com.anand.threads.phasers;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class AmusementPark {
    public static void main(String[] args) {
        Phaser ride = new Phaser(10);

        for(int i=0;i<100;i++){
//            if(i%10==0)
//                ride.arriveAndDeregister();

            ParkRide r = new ParkRide("Ride " + i,ride);
            r.start();

        }
    }
}
