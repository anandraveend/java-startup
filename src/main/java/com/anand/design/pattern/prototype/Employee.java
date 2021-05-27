package com.anand.design.pattern.prototype;

public class Employee implements Comparable<Employee>, Cloneable {
    private String someComplexAlog;

    Employee(String type){
        System.out.println("Created " + type);
        this.someComplexAlog = type;
    }

    public int compareTo(Employee e){
       return e.someComplexAlog.compareTo(this.someComplexAlog);
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public String toString(){
        return "Employee type : " + this.someComplexAlog;
    }
}
