package com.anand.generics;

public class UpperBoundGeneric {
	public static void addGeneric(GenericWrapper<? extends Number> x, GenericWrapper<? extends Number> y) {
		Number a = x.getWrapper();
		Number b = y.getWrapper();
		Number sum = a.doubleValue() + b.doubleValue();
		System.out.println(String.format("Adding two numbers %s + %s = %s", a,b,sum));
	}
}
