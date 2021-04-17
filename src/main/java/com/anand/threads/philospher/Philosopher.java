package com.anand.threads.philospher;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread{
	private String name;
	private Lock rFork;
	private Lock lFork;
	private int mealsHad;
	Philosopher(String name, Lock r, Lock l){
		this.name = name;
		this.rFork = r;
		this.lFork = l;
		this.mealsHad = 0;
		System.out.println(String.format("%s starting his day with #%s left fork and #%s right fork", name,lFork,rFork));
	}
	public void think() {
		System.out.println(name + " is thinking about his next meal ..." + mealsHad);
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(5));
		}catch(Exception e) {
			
		}
	}
	public void eat() {
		if(rFork.tryLock()) {			
			try {
				System.out.println(name + " has the right fork");
				if(lFork.tryLock()) {					
					try {
						System.out.println(name + " has the left fork");
						System.out.println(name + " is eating...");
						TimeUnit.SECONDS.sleep(new Random().nextInt(5));
						System.out.println(name + " is done eating...");
						this.mealsHad ++;
					}catch(Exception e) {
						
					}finally {
						lFork.unlock();
					}
				}
			}finally {
				rFork.unlock();
			}
		}
	}
	
	@Override
	public void run() {
		while(this.mealsHad < 3) {
			this.think();
			this.eat();
		}
		System.out.println(name+" is done for the day!");
	}
	
}
