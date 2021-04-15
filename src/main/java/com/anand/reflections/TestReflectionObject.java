package com.anand.reflections;

import java.lang.reflect.Constructor;

public class TestReflectionObject {
	public void createAnObjectUsingRefelection() throws Exception {
		System.out.println("=========createAnObjectUsingRefelection=============");
		Class<SampleReflectionClass> cl = SampleReflectionClass.class;
		Constructor<SampleReflectionClass> cons = cl.getConstructor();
		SampleReflectionClass obj = cons.newInstance();
		
		obj.aMethod();
		obj.bMethod(10);
	}
}
