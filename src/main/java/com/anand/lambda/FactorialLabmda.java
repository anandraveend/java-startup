package com.anand.lambda;

import java.util.function.IntFunction;

public class FactorialLabmda {
	public static void testFactorial(int n) {
		try {
			
			//Using Labmda method reference
			IntFunction<Integer> labmdaFactorial = FactorialLabmda::factorial;
			System.out.println(labmdaFactorial.apply(n));
			
			
			//Implementation using inner class
			//Use of inner class
			IntFunction<Integer> lambdaInnerFunction = new IntFunction<Integer>() {
				@Override
				public Integer apply(int x) {
					if(x<0) {
						throw new IllegalArgumentException("Invalid number. Cannot be < 0");		
					}
					
					if(x ==0)
						return 1;
					else
						return x * this.apply(x-1);
				}
			};
			
			System.out.println(lambdaInnerFunction.apply(n));
			
		}catch(Exception e) {
			
		}
	}
	
	public static int factorial(int x)  {
		if(x<0) {
			throw new IllegalArgumentException("Invalid number. Cannot be < 0");		
		}
		
		if(x ==0)
			return 1;
		else
			return x * factorial(x-1);
	}
	
	
	
}
