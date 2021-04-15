package com.anand.innerclasses;

import java.util.Iterator;

public class App {
	//member inner class
	public static class SubApp {
		public static int add(int a, int b) {
			return a+b;
		}
	}
	
	public static void main(String[] args) {
		//Implementation of an member inner class
		System.out.println(SubApp.add(1,2));
		
		//Implementation of a local inner class
		class LocalInner {
			public int add(int a, int b) {
				return a+b;
			}
		}
		//Can only be invoked inside this method
		LocalInner mb = new LocalInner();
		System.out.println(mb.add(1, 3));
		
		//Demo of member inner class
		TitleList lt = new TitleList();
		lt.addTitle("World War Z");
		lt.addTitle("The Shining");
		lt.addTitle("Digital Fortress");
		
		Iterator<String> it = lt.titleIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Demo of anonymous inner class
		TitleListAnonymous lta = new TitleListAnonymous();
		lta.addTitle("World War Z");
		lta.addTitle("The Shining");
		lta.addTitle("Digital Fortress");
		
		Iterator<String> ita = lta.titleIterator();
		while(ita.hasNext()) {
			System.out.println(ita.next());
		}
	}
	

}
