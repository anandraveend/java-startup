package com.anand.design.pattern.factory;

public class Truck extends Vehicle {
    Truck(String brnad){
        this.brand = brnad;
    }
    public void drive(){
        System.out.println(getClass() + " is driving !");
    }

    public void steer(){
        System.out.println(getClass() + " is steering!");
    }

    public void brake(){
        System.out.println(getClass() +" is braked!");
    }
}