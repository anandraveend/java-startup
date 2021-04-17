package com.anand.threads.philospher;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class PhilosophersCove {

	public static void main(String[] args) {
		ArrayList<ReentrantLock> forks = new ArrayList<ReentrantLock>();		
		IntStream.range(0, 5).forEach(i->{
			forks.add(new ReentrantLock());			
		});
		
		IntStream.range(0, 5).forEach(i->{
			int rFork = i;
			int lFork = rFork + 1;
			if(lFork == 5) lFork = 0; 
			Philosopher p = new Philosopher("Philosopher - "+i,forks.get(rFork),forks.get(lFork));
			p.start();
		});

	}

}
