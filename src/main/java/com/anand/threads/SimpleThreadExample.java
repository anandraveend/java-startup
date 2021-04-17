package com.anand.threads;

import java.util.Random;

public class SimpleThreadExample {
	private String name;
	SimpleThreadExample(String name){
		this.name=name;
	}
	public void work() {
		try {
			System.out.println(String.format("Start Executing thread - %s", this.name));
			Thread.sleep(new Random().nextInt(10000));
			System.out.println(String.format("Finish Executing thread - %s", this.name));
		}catch(Exception e) {
			
		}
	}
}
