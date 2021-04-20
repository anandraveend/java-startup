package com.anand.collections;

public class Human {
	private String name;
	private int id;
	public String getName() {
		return this.name;
	}
	Human(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Human :" + this.name + " #" + this.id;
	}
}
