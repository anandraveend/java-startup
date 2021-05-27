package com.anand.threads;

import java.util.stream.IntStream;

public class SyncAsyncThreadTest {

	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(i->{
			Thread t1 = new Thread(new SimpleThreadExample("Thread#"+i)::work);
			t1.start();
		});
		
		IntStream.range(1, 10).forEach(i->{
			Thread t1 = new Thread(new SimpleThreadExample("Thread#"+i)::work);
			t1.start();
		});
		
		//Sync vs non synced 
		IntStream.range(1, 10).forEach(i-> {
			SynchronizedThreadExample t = new SynchronizedThreadExample();
			NotSyncThread nt = new NotSyncThread();
			t.start();			
			nt.start();
		});
	}

}
