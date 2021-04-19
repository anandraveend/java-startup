package com.anand.decorator;

import java.io.Serializable;

public abstract class Drink implements Serializable{
	protected String name;
	protected double price;
	
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return String.format("%s @ %f", this.name,this.price);
	}
}
