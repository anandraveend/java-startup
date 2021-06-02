package com.anand.design.pattern.decorator;

public class Spicey extends DrinkDecorator{
	public Spicey(Drink drink) {
		this.drink = drink;
		this.name = "Spicey!";
		this.price = 0.75;
	}
	
}
