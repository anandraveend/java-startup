package com.anand.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ListTest {

	public static void main(String[] args) {
		
		System.out.println("Read optimized");
		Runnable r1 = () -> {reads(new LinkedList<Integer>());};
		Runnable r2 = () -> {reads(new ArrayList<Integer>());};

		System.out.println("Write optimized");
		Runnable r3 = () -> {write(new LinkedList<Integer>());};
		Runnable r4 = () -> {write(new ArrayList<Integer>());};

		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();
		new Thread(r4).start();
	}
	
	public static void reads(List<Integer> l) {		
		long startTime = System.currentTimeMillis();
		//Populate list
		IntStream.range(0, 100000).forEach(i->{
			l.add(i);
		});
		
		//Addition at the end only
		IntStream.range(0, 100000).forEach(i->{
			l.add(i);
		});
		
		//Randomized reads
		Random r = new Random();
		for(int i=0; i< l.size();i++) {
			Integer x = l.get(r.nextInt(100000));
		}
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("%s execution in %s milliseconds",  l.getClass().getName(),(endTime-startTime)));
		
	}
	
	public static void write(List<Integer> l) {
		long startTime = System.currentTimeMillis();
		//Populate list
		System.out.println("Populating " + l.getClass().getName());
		IntStream.range(0, 100000).forEach(i->{
			l.add(i);
		});
		
		//Empty list 
		System.out.println("Emptying " + l.getClass().getName());
		for(int i=0;i< l.size();i++) {
			l.remove(0);
		}
		
		IntStream.range(0, 100000).forEach(i->{
			l.add(i);
		});
		
		//Randomized reads
		System.out.println("Random reads " + l.getClass().getName());
		Random r = new Random();
		for(int i=0; i< l.size();i++) {
			Integer x = l.get(r.nextInt(100000));
		}

		//Randomized writes		
		System.out.println("Random writes " + l.getClass().getName());
		int size = l.size();
		for(int i=0; i< size;i++) {
			l.add(i, r.nextInt(100000));
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("%s execution in %s milliseconds", l.getClass().getName(), (endTime-startTime)));
		
	}

}
