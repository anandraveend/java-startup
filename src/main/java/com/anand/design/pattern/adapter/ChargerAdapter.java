package com.anand.design.pattern.adapter;

public interface ChargerAdapter {
    public Charger getEuroCharger();
    public Charger getUSCharger();
    public Charger getIndianCharger();
}
