package com.anand.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassLiteral {
		public void classLiteraltest() {
			System.out.println("====================classLiteraltest=============");
			Class<SampleReflectionClass> refClass1= SampleReflectionClass.class;
			
			for(Field f: refClass1.getDeclaredFields()) {
				System.out.println(f.getName());
			}
			
			for(Method m: refClass1.getMethods()) {
				System.out.println(m.getName());
			}
		}
		
		public void objGetClass() {
			System.out.println("====================objGetClass=============");
			SampleReflectionClass obj = new SampleReflectionClass();
			Class refClass1 =  obj.getClass();
			for(Field f: refClass1.getDeclaredFields()) {
				System.out.println(f.getName());
			}
			
			for(Method m: refClass1.getMethods()) {
				System.out.println(m.getName());
			}
		}
		
		public void usingForName() {
			System.out.println("====================usingForName=============");
			try {
				//Needs the fully qualified name
				Class refClass1=Class.forName("com.anand.reflections.SampleReflectionClass");
				
				for(Field f: refClass1.getDeclaredFields()) {
					System.out.println(f.getName());
				}
				
				for(Method m: refClass1.getMethods()) {
					System.out.println(m.getName());
				}
			}catch(Exception e) {
				System.out.println("Class not found :" + e.getMessage());
			}
		}
		
		public void usingForNameUsingClassLoader() {
			System.out.println("====================usingForNameUsingClassLoader=============");
			try {
				//Needs the fully qualified name
				ClassLoader cl = SampleReflectionClass.class.getClassLoader();
				Class refClass1=Class.forName("com.anand.reflections.SampleReflectionClass",true,cl);
				
				for(Field f: refClass1.getDeclaredFields()) {
					System.out.println(f.getName());
				}
				
				for(Method m: refClass1.getMethods()) {
					System.out.println(m.getName());
				}
			}catch(Exception e) {
				System.out.println("Class not found :" + e.getMessage());
			}
		}
		
		
	
}
