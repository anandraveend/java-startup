package com.anand.io;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PipedStreamTest {

	public static void main(String[] args) {
		PipedInputStream pin = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		try {
			pos.connect(pin);
			Runnable producer = ()->producer(pos);
			Runnable consumer = ()->consumer(pin);
			Thread p = new Thread(producer);
			Thread c = new Thread(consumer);
			p.start();
			c.start();
		}catch(Exception e) {
			
		}
		
	}
	public static void producer(PipedOutputStream pos) {	
		IntStream.range(0, 100).forEach(i->{
			try {
				pos.write((byte)i);
				pos.flush();
				System.out.println("Wrote " + i);
//				TimeUnit.SECONDS.sleep(2);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
		});		
		try {
			pos.close();
		}catch(Exception e){}
	}
	
	public static void consumer(PipedInputStream pis) {
		try {
			int data=-1;
			while((data = pis.read())!=-1) {
				System.out.println("Read "+data);
			}
			pis.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
