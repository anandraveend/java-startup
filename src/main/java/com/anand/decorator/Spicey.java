package com.anand.decorator;

public class Spicey extends DrinkDecorator{
	public Spicey(Drink drink) {
		this.drink = drink;
		this.name = "Spicey!";
		this.price = 0.75;
	}
	
}
