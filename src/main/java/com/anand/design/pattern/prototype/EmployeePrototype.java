package com.anand.design.pattern.prototype;

import java.util.*;

public class EmployeePrototype implements Cloneable {
    private Map<String,Employee> employees;

    private void init(){
        this.employees.put("manager",new Employee("Manager"));
        this.employees.put("tech",new Employee("Tech"));
    }

    public EmployeePrototype(){
        this.employees = new Hashtable<>();
        this.init();
    }

    public Employee getEmployee(String type){
        Employee e = null;
        try{
            e=(Employee)this.employees.get(type).clone();


        }catch(CloneNotSupportedException ex){
            System.out.println(ex.getMessage());
        }
        return e;
    }

}
