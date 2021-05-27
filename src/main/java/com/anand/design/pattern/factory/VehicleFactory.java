package com.anand.design.pattern.factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String type, String brand){
        if (type.equals("Car"))
            return new Car(brand);
        else return new Truck(brand);

    }
}
