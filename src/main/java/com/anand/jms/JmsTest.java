package com.anand.jms;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JmsTest {
    public static void main(String[] args) {
        MQConnectionFactory factory = new MQConnectionFactory();
        List<Thread> threads = new ArrayList();
        for(int i=0;i<2;i++){
            ConsumerThread c= new ConsumerThread(factory);
            Thread t = new Thread(c);
            t.setName("Consumer#" + i);
            t.start();
            threads.add(t);
        }

        for(int i=0;i<10;i++){
            ProducerThread c= new ProducerThread(factory);
            Thread t = new Thread(c);
            t.setName("Producer#" + i);
            t.start();
            threads.add(t);
        }

        while (threads.size() > 0) {
            ListIterator it = threads.listIterator();
            while(it.hasNext()){
                Thread t = (Thread)it.next();
                System.out.println(t.getName() + " :" + t.getState());
                try {
                    Thread.sleep(1000);
                    if(!t.isAlive())
                        it.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        factory.cleanUpOnClose();

    }
}
