package com.anand.threads.producer.consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread{
	private final Buffer buffer;
	private int runCycles;
	Producer(Buffer buffer, int runCycles){
		this.buffer = buffer;
		this.runCycles = runCycles;
	}
	
	@Override
	public void run() {			
		while (runCycles > 0) {
			int data = new Random().nextInt();		
			buffer.produce(data);
			try {
				TimeUnit.SECONDS.sleep(2L);
			}catch(InterruptedException e) {
				
			}
			runCycles--;
		}
	}
}
