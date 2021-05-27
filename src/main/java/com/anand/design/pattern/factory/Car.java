package com.anand.design.pattern.factory;

public class Car extends Vehicle {
    Car(String brand){
        this.brand = brand;
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
