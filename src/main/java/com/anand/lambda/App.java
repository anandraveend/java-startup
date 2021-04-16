package com.anand.lambda;

public class App {
	public static void main(String[] args) {
		Adder l = (a,b)->a+b;
		int sum = l.add(3, 4);
		System.out.println(sum);
		
		//Lambda usage
		String[]names= {"Anand","Raji","Ananya"};
		int strLens[] = Mapper.mapToInt(names, (String name)-> name.length());
		for(int i=0;i<strLens.length;i++) {
			System.out.println(String.format("Length of %s : %d", names[i],strLens[i]));
		}
		
		
		Integer[] numbers = {1,2,3};
		int cubes[] = Mapper.mapToInt(numbers, (Integer i)-> i*i*i);
		
		for(int i=0;i<strLens.length;i++) {
			System.out.println(String.format("Cube of %d : %d", numbers[i],cubes[i]));
		}
		
		//Predefined functions
		FunctionInterface.testFunctionalInterface();
		
		//Predicate functions
		PredicateTest.testPredicates();
		
		//Method reference
		FactorialLabmda.testFactorial(10);
	}
}
