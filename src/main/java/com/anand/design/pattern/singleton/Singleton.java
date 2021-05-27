package com.anand.design.pattern.singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private List<String> register;

    private static Singleton singleton;

    private Singleton(){
        this.register = new ArrayList<String>();
    }

    public static Singleton getSingleton(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    public List<String> getRegister(){
        return this.register;
    }
}
