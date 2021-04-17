package com.anand.threads.producer.consumer;

public class Buffer {
	private int value;
	private boolean empty;
	
	Buffer(){
		this.empty = true;
	}
	
	public synchronized void produce(int n) {
		while(!empty) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				System.out.println("This is the end!");
			}
		}
		this.value = n;
		this.empty = false;
		this.notify();
		System.out.println("Produced "+ n);
	}
	
	public synchronized int consume() {
		while(empty) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				System.out.println("Death is just the beginning!");
			}
		}
		this.empty=true;
		this.notify();
		System.out.println("Consumed " + this.value);
		return this.value;
	}

}
