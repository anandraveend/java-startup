package com.anand.innerclasses;

import java.util.ArrayList;

public class CallbackTest {
	private ArrayList<Callable> callableList = new ArrayList<Callable>();
	
	public void register(Callable t) {
		callableList.add(t);
	}
	
	public void callBack() {
		for(Callable c: callableList) {
			c.call();
		}
	}
	
	public void testCallable() {
		//register a test call
		this.register(new Callable(){
			@Override
			public void call() {
				System.out.println("Hello world!");
			}
		});
		
		//register another test call
		this.register(new Callable(){
			@Override
			public void call() {
				System.out.println("Hello world for the last time");
			}
		});
	}
}
