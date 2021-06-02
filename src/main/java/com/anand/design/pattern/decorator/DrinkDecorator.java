package com.anand.design.pattern.decorator;

public abstract class DrinkDecorator extends Drink{
	protected Drink drink;
	
	@Override 
	public String getName() {
		return this.name + "," + drink.getName();
	}
	@Override
	public double getPrice() {
		return this.price + drink.getPrice();
	}
	
	public Drink getDrink() {
		return this.drink;
	}
	
	public String toString() {
		return String.format("%s @ %f", this.getName(),this.getPrice());
	}
}
