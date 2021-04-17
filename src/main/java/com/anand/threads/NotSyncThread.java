package com.anand.threads;

import java.util.Random;

public class NotSyncThread extends Thread{
	private static int sharedValue=0;
	
	public static void nonSyncedWork(String name) {
		try {
			System.out.println(String.format("NSync Start Executing thread - %s at %d", name,sharedValue));
			sharedValue++;
			System.out.println(String.format("NSync Finish Executing thread - %s at %d", name,sharedValue));
		}catch(Exception e) {
			
		}
	}
	
	@Override 
	public void run() {
		NotSyncThread.nonSyncedWork(new Random().nextInt(10) + "");
	}

}
