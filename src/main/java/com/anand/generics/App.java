package com.anand.generics;

public class App {

	public static void main(String[] args) {
		GenericWrapper<String> ref = new GenericWrapper<String>("Hello World!");
		ref.setWrapper("Hello");
		System.out.println("Got back "+ ref.getWrapper());
		
		GenericWrapper<Object> ref1 = new GenericWrapper<Object>(10);
		System.out.println("Got back #2 "+ ref1.getWrapper());
		ref1.setWrapper("Hello");
		System.out.println("Got back #2 "+ ref1.getWrapper());
		
		GenericWrapper<Double> num1= new GenericWrapper<Double>(1.25);
		GenericWrapper<Integer> num2= new GenericWrapper<Integer>(10);
		
		//Only allows you to invoke the methods for types that inherit from Number type
		UpperBoundGeneric.addGeneric(num1, num2);
	}

}
