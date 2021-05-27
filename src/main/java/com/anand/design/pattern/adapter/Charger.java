package com.anand.design.pattern.adapter;

public class Charger {
    private int volts;

    Charger(int volts){
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    @Override
    public String toString() {
        return "Charging at " + volts;
    }
}
