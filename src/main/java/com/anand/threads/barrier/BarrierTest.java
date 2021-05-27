package com.anand.threads.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierTest {
    public static void main(String[] args) {
        Runnable campfire = () -> {
            System.out.println("Enjoy the campfire party guys!!!");
        };

        CyclicBarrier campingDuties = new CyclicBarrier(3,campfire);

        BoyScout a1 = new BoyScout("firewood",campingDuties);
        BoyScout a2 = new BoyScout("water",campingDuties);
        BoyScout a3 = new BoyScout("tents",campingDuties);

        a1.start();
        a2.start();
        a3.start();
    }
}
