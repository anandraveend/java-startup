package com.anand.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectionMethod {
	public void testMethodExecution() {
		System.out.println("=======testMethodExecution=========");
		Class<SampleReflectionClass> cl = SampleReflectionClass.class;
		try {
			SampleReflectionClass obj = cl.newInstance(); 
			Method mtd = cl.getMethod("aMethod");
			mtd.invoke(obj);
			
			//Need to specify the input params that need to be passed to a method
			mtd = cl.getMethod("bMethod", int.class);
			mtd.invoke(obj, 10);
			
			//passing Multiple params to a method
			Class[] params = new Class[2];
			params[0]=int.class;
			params[1]=int.class;
			mtd = cl.getMethod("cMethod", params);
			mtd.invoke(obj, 10,10);
		
			//How to track multiple exceptions in a single catch
		}catch(InstantiationException | IllegalAccessException
				| NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}
}
