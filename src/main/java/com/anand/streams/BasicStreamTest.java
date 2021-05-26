package com.anand.streams;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStreamTest {

	public static void main(String[] args) {
		//Java 8 syntax
		List<Integer> i = Arrays.asList(1,2,3,4,5);
		
		//Java 9 syntax
//		List<Integer> i = List.of(1,2,3,4);
		
		int crazySum = i.stream().filter(n->n%2==0).map(n->n*n).reduce(0,Integer::sum);
		System.out.println(crazySum);

	int[] test = {1,1,3,5,6,2,3,4,6,8,11,10,4,4,3,3,3,1};
	List<Integer> uniq = Arrays.stream(test).distinct().boxed().collect(Collectors.toList());
	System.out.println(uniq);
	System.out.println("Dupes = " + (test.length - uniq.size()));
	}

}
