package com.anand.design.pattern.builder;

public class BuilderTest {
    public static void main(String[] args){
        Computer c = new Computer.ComputerBuilder("500GB","200PB").build();
        System.out.println(c.getHdd());
        System.out.println(c.getRam());

    }

}
