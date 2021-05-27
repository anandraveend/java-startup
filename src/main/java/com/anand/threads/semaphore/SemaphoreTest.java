package com.anand.threads.semaphore;

import java.util.Random;
import java.util.stream.IntStream;

public class SemaphoreTest {
    public static void main(String[] args) {
        Restaurant charminar = new Restaurant();
        IntStream.range(1,10).forEach(e->{
            Patron p1 = new Patron("Group#"+e,new Random().nextInt(10), charminar);
            p1.start();
        });
    }
}
