package com.anand.generics;

public class GenericStatsDemo {
    public static void main(String[] args) {
        Integer[] i = {1,2,3,4,5};
        GenericStats<Integer> si= new GenericStats<>(i);

        Double[]d = {1.0,2.0,3.0,4.0,5.0};
        GenericStats<Double> di= new GenericStats<>(d);

        Float[]f = {1.0f,2.0f,3.0f,4.0f,5.0f};
        GenericStats<Float> fi= new GenericStats<>(f);

        if(si.avg() == di.avg())
            System.out.println("Integer == Double");

        if(si.avg() == fi.avg())
            System.out.println("Integer == Float");

    }
}
