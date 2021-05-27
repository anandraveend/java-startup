package com.anand.design.pattern.singleton;

import java.util.List;

public class SingletonTest {
    public static void main(String[] args){
        Singleton s1 = Singleton.getSingleton();
        s1.getRegister().add("Hello ");

        Singleton s2 = Singleton.getSingleton();
        s2.getRegister().add("World!");
        List all=Singleton.getSingleton().getRegister();

        System.out.println(String.join(" ",all));
    }
}
