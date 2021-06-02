package com.anand.design.pattern.decorator;

public class Bartender {
	public static void main(String [] args) {
		
		Drink spicyHoneyWhiskey = new Spicey(new Honey(new Whiskey()));
		
		System.out.println("That was a great " + spicyHoneyWhiskey);
		System.out.println(String.format("Indeed. Your bill for tonight is %f", spicyHoneyWhiskey.getPrice()));
	}
}
