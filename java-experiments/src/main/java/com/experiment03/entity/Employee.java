package com.experiment03.entity;

public abstract class Employee implements Workable {
    public String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    @Override
    public void updateName(String newName) {
        this.name = newName;
    }
}