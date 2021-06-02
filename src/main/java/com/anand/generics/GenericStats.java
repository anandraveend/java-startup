package com.anand.generics;

import java.util.Arrays;

public class GenericStats<T extends Number> {
    T[] nums;

    GenericStats(T[] arr){
        this.nums = arr;
    }

    double avg(){
        return Arrays.stream(this.nums).mapToDouble(t-> t.doubleValue()).reduce((a,b)-> a+b).getAsDouble();

    }

    boolean sameAvg(GenericStats<?> o){
        return o.avg() == this.avg();
    }
}
