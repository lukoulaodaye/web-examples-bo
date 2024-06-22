package com.experiment03.entity;

public class Manager extends Employee {
    private int level;

    public Manager(String name, double basicSalary, int level) {
        super(name, basicSalary);
        this.level = level;
    }

    @Override
    public double calculateSalary() {
        return basicSalary * level * 0.8;
    }
}