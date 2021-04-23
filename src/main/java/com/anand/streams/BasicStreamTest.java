package com.anand.streams;

import java.util.*;

public class BasicStreamTest {

	public static void main(String[] args) {
		//Java 8 syntax
		List<Integer> i = Arrays.asList(1,2,3,4,5);
		
		//Java 9 syntax
//		List<Integer> i = List.of(1,2,3,4);
		
		int crazySum = i.stream().filter(n->n%2==0).map(n->n*n).reduce(0,Integer::sum);
		System.out.println(crazySum);
	}

}
