package com.anand.threads.producer.consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread{
 private final Buffer buffer;
 private int runCycles;
 
 Consumer(Buffer buffer, int runCycles){
	 this.buffer = buffer;
	 this.runCycles = runCycles;
 }
 
 @Override
 public void run() {
	 while (runCycles > 0) {
		int data = buffer.consume();
		try {
			TimeUnit.SECONDS.sleep(2L);
		}catch(InterruptedException e) {
			
		}
		runCycles--;
	}
 }
}
