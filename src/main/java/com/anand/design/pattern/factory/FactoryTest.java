package com.anand.design.pattern.factory;

public class FactoryTest {
    public static void main(String[] args){
        Vehicle subaru = VehicleFactory.getVehicle("Car","Subaru");
        Vehicle mack = VehicleFactory.getVehicle("Truck","Mack");
        subaru.drive();
        subaru.steer();
        mack.drive();
        mack.brake();
    }
}
