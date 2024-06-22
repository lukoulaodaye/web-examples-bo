package com.experiment03.entity;

public class Seller extends Employee {
    private double salesAmount;
    private double commissionRate;

    public Seller(String name, double basicSalary, double salesAmount, double commissionRate) {
        super(name, basicSalary);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + salesAmount * commissionRate;
    }
}