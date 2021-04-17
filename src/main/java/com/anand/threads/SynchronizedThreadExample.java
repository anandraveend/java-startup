package com.anand.threads;

import java.util.Random;

public class SynchronizedThreadExample extends Thread {
	private static int sharedValue=0;	
	public synchronized static void syncedWork(String name) {
		try {
			System.out.println(String.format("Start Executing thread - %s at %d", name,sharedValue));
			sharedValue++;
			System.out.println(String.format("Finish Executing thread - %s at %d", name,sharedValue));
		}catch(Exception e) {
			
		}
	}
	@Override 
	public void run() {
		SynchronizedThreadExample.syncedWork(new Random().nextInt(10) + "");
	}
}
