package com.anand.reflections;

import java.util.ArrayList;

public class SampleReflectionClass {
	static {
		System.out.println("Initialized class");
	}
	public static ArrayList<String> aList = new ArrayList<String>();
	public void aMethod() {System.out.println("In aMethod");}
	public void bMethod(int x) {System.out.println("In bMethod. Got " + x);}
	public void cMethod(int x,int y) {System.out.println("In cMethod. Got " + x + " and " + y);}
	public static void aStaticMethod() {System.out.println("In aStaticMethod");}
	
}
