package com.anand.collections;

public class Person implements Comparable{
	private String name;
	public String getName() {
		return this.name;
	}
	Person(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person :" + this.name;
	}
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Person ))
			return -1;
		Person p = (Person) o;
		return p.getName().compareTo(this.name);
	}
	
	@Override 
	public boolean equals(Object o) {
		if(!(o instanceof Person ))
			return false;
		Person p = (Person) o;
		return p.getName().equals(this.name);
	}

}
