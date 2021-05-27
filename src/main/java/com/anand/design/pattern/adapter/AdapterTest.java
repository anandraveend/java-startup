package com.anand.design.pattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        AdapterImpl adaptor = new AdapterImpl();
        Charger euro = adaptor.getEuroCharger();
        Charger indian = adaptor.getIndianCharger();

        System.out.println(euro);
        System.out.println(indian);
    }
}
