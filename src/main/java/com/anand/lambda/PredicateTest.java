package com.anand.lambda;

import java.util.function.Predicate;

public class PredicateTest {
	public static void testPredicates() {
		Predicate<Integer> isEven = x -> x%2 ==0;
		Predicate<Integer> isOdd = isEven.negate();
		
		System.out.println(isEven.test(10));
		System.out.println(isOdd.test(10));
	}
}
