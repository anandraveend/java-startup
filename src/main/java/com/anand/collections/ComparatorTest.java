package com.anand.collections;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import com.anand.io.FileFilterTest;

public class ComparatorTest {

	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir") + File.separator + "target";
		List<File> classFiles = FileFilterTest.findFileByPrefix(new File(cwd), "class");
		
		Set<String> treeSet = new TreeSet<String>();
		
		classFiles.forEach(f->{
			treeSet.add(f.toPath().getFileName().toString());
		});
		
		treeSet.forEach(System.out::println);
		
		//Using a class that implements Comparable interface
		SortedSet<Person> pSet = new TreeSet<Person>();
		
		//Using a custom comparator
		SortedSet<Human> hSet = new TreeSet<Human>(Comparator.comparing(Human::getName));
		
		//Navigable set 
		NavigableSet<Person> np = new TreeSet<Person>();
		
		
		IntStream.range(1, 100).forEach(i->{
			int ii = new Random().nextInt(10);
//			System.out.println("Adding "+ii);
			pSet.add(new Person("Person#" + ii));
			hSet.add(new Human("Human#" + ii, ii));
			np.add(new Person("Person#" + ii));
		});
		pSet.forEach(System.out::println);
		hSet.forEach(System.out::println);
		
		np.forEach(System.out::println);
		np.descendingSet().forEach(System.out::println);
		
	}

}
