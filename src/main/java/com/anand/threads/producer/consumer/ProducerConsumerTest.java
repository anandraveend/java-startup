package com.anand.threads.producer.consumer;

import java.util.Random;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		int runCycles = new Random().nextInt(10);
		Producer p = new Producer(buffer,runCycles);
		Consumer c = new Consumer(buffer,runCycles);
		p.start();
		c.start();
		
	}
}
