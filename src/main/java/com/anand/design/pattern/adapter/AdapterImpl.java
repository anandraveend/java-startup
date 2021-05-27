package com.anand.design.pattern.adapter;

public class AdapterImpl implements ChargerAdapter {
    @Override
    public Charger getEuroCharger(){
        return new Charger(220);
    }

    @Override
    public Charger getIndianCharger() {
        return new Charger(240);
    }

    @Override
    public Charger getUSCharger() {
        return new Charger(120);
    }
}
