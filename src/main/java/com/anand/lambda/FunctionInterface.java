package com.anand.lambda;

import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionInterface {
	public static void testFunctionalInterface() {
		System.out.println("==========testFunctionalInterface==========");
		Function<Integer,Integer> square = x -> x*x;
		IntFunction<Integer> dbl = y-> y*2;
		
		System.out.println(square.apply(10) );
		System.out.println(dbl.apply(10) );
		Function<Integer,Integer> addOne = x-> x+1;
		Function<Integer,Integer> squareAddOne = square.andThen(addOne);
		
		System.out.println(squareAddOne.apply(10));
		
	}
}
