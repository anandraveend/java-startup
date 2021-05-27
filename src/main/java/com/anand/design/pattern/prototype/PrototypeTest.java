package com.anand.design.pattern.prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        Employee e = new EmployeePrototype().getEmployee("tech");
        Employee m = new EmployeePrototype().getEmployee("manager");
        System.out.println(e);
        System.out.println(m);
    }
}
