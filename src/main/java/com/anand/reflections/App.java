package com.anand.reflections;

public class App {

	public static void main(String[] args) {
		ClassLiteral cl = new ClassLiteral();
		cl.classLiteraltest();
		cl.objGetClass();
		cl.usingForName();
		cl.usingForNameUsingClassLoader();
		
		//Create an object using reflection
		TestReflectionObject ro = new TestReflectionObject();
		try {
			ro.createAnObjectUsingRefelection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
		TestReflectionMethod rm = new TestReflectionMethod();
		rm.testMethodExecution();
		
		ArrayReflectionTest et = new ArrayReflectionTest();
		et.testArrayReflection();
	}

}
